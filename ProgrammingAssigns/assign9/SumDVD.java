import javax.xml.stream.*;
import java.io.*;
import java.util.*; 
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class SumDVD {
  private void CreatSum(ArrayList<String> decades, int[] cnt)
  {
    String fn = "./sum.xml";
    XMLStreamWriter xw =  null; 
    XMLOutputFactory xof = XMLOutputFactory.newInstance(); 
    try {
        xw =  xof.createXMLStreamWriter(new FileWriter(fn));
        xw.writeStartDocument("1.0");
        xw.writeDTD("<!DOCTYPE  DVDS SYSTEM \"sum.dtd\">");
        xw.writeStartElement("DVD");

        xw.writeStartElement("summary");
        for(int i = 0; i < decades.size(); i++)
        {
          xw.writeStartElement("count");
          xw.writeAttribute("decade", decades.get(i));
          xw.writeCharacters(Integer.toString(cnt[i]));
          xw.writeEndElement();         
        }

        xw.writeEndElement();  // summary
        xw.writeEndElement();  // DVD
        xw.writeEndDocument();
        xw.flush();
        xw.close(); 
    } catch  (XMLStreamException e) {
          e.printStackTrace();
    } catch (IOException e)  {
          e.printStackTrace();
    }
  }

public void read(String filepath) {
  try {
    FileInputStream fileInputStream = new  FileInputStream(filepath);
         XMLInputFactory factory = XMLInputFactory.newInstance();
         XMLStreamReader xmlStreamReader = 
             factory.createXMLStreamReader(fileInputStream);

    ArrayList<String> arr = new ArrayList<String>();
    while (xmlStreamReader.hasNext()) {
      String result = readDVDList(xmlStreamReader);
      if(result != null)
      {
        arr.add(result);
      }
    }

    CreatSum(cleanArrList(arr), cntArrList(arr));

    xmlStreamReader.close();

  } catch  (XMLStreamException e) {
    e.printStackTrace(); 
  } catch  (FileNotFoundException e) {
    e.printStackTrace(); 
  }
}
private String readDVDList(XMLStreamReader reader) throws XMLStreamException {
  String r = "";
  int eventCode =  reader.next(); 
  switch (eventCode) {
    case XMLStreamReader.START_ELEMENT:
      String key = reader.getLocalName();
      if (key.equals("DVD")) {
        r = readDVD(reader);
      }
      return r;
  }
  return null;
}
  
private String readDVD(XMLStreamReader reader) throws XMLStreamException {
  String name = "";
  String value = "";
  String decade = "";

  int nAttributes =  reader.getAttributeCount();
  String avalue =  reader.getAttributeValue(0);
  // System.out.println("attribute  value: " + avalue + " attribute count: " + nAttributes);

  while (reader.hasNext()) {
  int eventCode = reader.next();
       switch (eventCode) {
       case XMLStreamReader.START_ELEMENT:
            name =  reader.getLocalName();
            break;
       case XMLStreamReader.END_ELEMENT:
            name =  reader.getLocalName();
            if (name.equals("DVD"))  return null;  
            break;
       case XMLStreamReader.CHARACTERS:
            value =  reader.getText();
            if(name.equals("release_year"))
            {
              decade = parseDecade(value);
            }            
            // System.out.println("Element  name= " + name + " value=" + value);
            // System.out.println(name.getClass());
            break;
       }
  }
  return decade;
}
 
private String parseDecade(String year_s)
{
  int year = Integer.valueOf(year_s);
  String decade = Integer.toString(10 * year / 10);
  return decade;
}

private ArrayList<String> cleanArrList(ArrayList<String> as)
{
  ArrayList<String> newList = new ArrayList<String>();
  for(String a : as)
  {
    if(!newList.contains(a)){
      newList.add(a);
    }
  }
  return newList;
}

private int[] cntArrList(ArrayList<String> as)
{
  ArrayList<String> clean = cleanArrList(as);
  int[] cnt = new int[clean.size()];
  for(String a : as)
  {
    int idx = clean.indexOf(a);
    cnt[idx]++;
  }
  return cnt;
}
 public static void  main(String[] args) {
 SumDVD dvdReader =  new SumDVD();
 dvdReader.read("dvds.xml");
 }
}