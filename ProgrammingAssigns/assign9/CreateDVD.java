import javax.xml.parsers.*;
import javax.xml.stream.*;
import java.io.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class CreateDVD
{
	public static void main(String[] arg)
	{
		String fn = "./dvds.xml";
		XMLStreamWriter xw =  null; 
		XMLOutputFactory xof = XMLOutputFactory.newInstance(); 
		try {
				xw =  xof.createXMLStreamWriter(new FileWriter(fn));
				xw.writeStartDocument("1.0");
				xw.writeDTD("<!DOCTYPE  DVDS SYSTEM \"dvds.dtd\">");
				xw.writeStartElement("DVDS");

				// DVD1
				xw.writeStartElement("DVD");
				xw.writeAttribute("id",  "1");
				
				xw.writeStartElement("release_year");
				xw.writeCharacters("2002");
				xw.writeEndElement();
				xw.writeStartElement("title");
				xw.writeCharacters("Star  Wars: Attack of the Clones");
				xw.writeEndElement();

				String []  performers = {
				  "Ewan  McGregor",
				  "Natalie  Portman", 
				  "Hayden  Christensen"
				};
				xw.writeStartElement("performers");
				for (String  performer : performers) {
				  xw.writeStartElement("performer");
				  xw.writeCharacters(performer);
				  xw.writeEndElement();
				}
				xw.writeEndElement(); 
				xw.writeStartElement("discs");
				xw.writeCharacters("2");
				xw.writeEndElement();
				xw.writeStartElement("price");
				xw.writeCharacters("14.99");
				xw.writeEndElement(); 
				xw.writeEndElement();

				// DVD2
				xw.writeStartElement("DVD");
				xw.writeAttribute("id",  "2");
				
				xw.writeStartElement("release_year");
				xw.writeCharacters("1999");
				xw.writeEndElement();
				xw.writeStartElement("title");
				xw.writeCharacters("Star  Wars: The Phantom Menace");
				xw.writeEndElement();

				String []  performers1 = {
				  "Ewan  McGregor",
				  "Natalie  Portman", 
				  "Hayden  Christensen"
				};
				xw.writeStartElement("performers");
				for (String  performer : performers1) {
				  xw.writeStartElement("performer");
				  xw.writeCharacters(performer);
				  xw.writeEndElement();
				}
				xw.writeEndElement(); 
				xw.writeStartElement("discs");
				xw.writeCharacters("2");
				xw.writeEndElement();
				xw.writeStartElement("price");
				xw.writeCharacters("14.99");
				xw.writeEndElement(); 
				xw.writeEndElement();

				// DVD 3
				xw.writeStartElement("DVD");
				xw.writeAttribute("id",  "3");
				
				xw.writeStartElement("release_year");
				xw.writeCharacters("2005");
				xw.writeEndElement();
				xw.writeStartElement("title");
				xw.writeCharacters("Star  Wars: Revenge of the Sith");
				xw.writeEndElement();

				String []  performers2 = {
				  "Ewan  McGregor",
				  "Natalie  Portman", 
				  "Hayden  Christensen"
				};
				xw.writeStartElement("performers");
				for (String  performer : performers2) {
				  xw.writeStartElement("performer");
				  xw.writeCharacters(performer);
				  xw.writeEndElement();
				}
				xw.writeEndElement(); 
				xw.writeStartElement("discs");
				xw.writeCharacters("2");
				xw.writeEndElement();
				xw.writeStartElement("price");
				xw.writeCharacters("14.99");
				xw.writeEndElement(); 
				xw.writeEndElement();

				// DVD4
	 			xw.writeStartElement("DVD");
				xw.writeAttribute("id",  "4");
				
				xw.writeStartElement("release_year");
				xw.writeCharacters("1977");
				xw.writeEndElement();
				xw.writeStartElement("title");
				xw.writeCharacters("Star  Wars: A New Hope");
				xw.writeEndElement();

				String []  performers3 = {
				  "Ewan  McGregor",
				  "Natalie  Portman", 
				  "Hayden  Christensen"
				};
				xw.writeStartElement("performers");
				for (String  performer : performers3) {
				  xw.writeStartElement("performer");
				  xw.writeCharacters(performer);
				  xw.writeEndElement();
				}
				xw.writeEndElement(); 
				xw.writeStartElement("discs");
				xw.writeCharacters("2");
				xw.writeEndElement();
				xw.writeStartElement("price");
				xw.writeCharacters("14.99");
				xw.writeEndElement(); 
				xw.writeEndElement();


				//DVD5
				xw.writeStartElement("DVD");
				xw.writeAttribute("id",  "5");
				
				xw.writeStartElement("release_year");
				xw.writeCharacters("1980");
				xw.writeEndElement();
				xw.writeStartElement("title");
				xw.writeCharacters("Star  Wars: The Empire Strikes Back");
				xw.writeEndElement();

				String []  performers4 = {
				  "Ewan  McGregor",
				  "Natalie  Portman", 
				  "Hayden  Christensen"
				};
				xw.writeStartElement("performers");
				for (String  performer : performers4) {
				  xw.writeStartElement("performer");
				  xw.writeCharacters(performer);
				  xw.writeEndElement();
				}
				xw.writeEndElement(); 
				xw.writeStartElement("discs");
				xw.writeCharacters("2");
				xw.writeEndElement();
				xw.writeStartElement("price");
				xw.writeCharacters("14.99");
				xw.writeEndElement(); 
				xw.writeEndElement();

				//DVD6
				xw.writeStartElement("DVD");
				xw.writeAttribute("id",  "6");
				
				xw.writeStartElement("release_year");
				xw.writeCharacters("1983");
				xw.writeEndElement();
				xw.writeStartElement("title");
				xw.writeCharacters("Star  Wars: Return of the Jedi");
				xw.writeEndElement();

				String []  performers5 = {
				  "Ewan  McGregor",
				  "Natalie  Portman", 
				  "Hayden  Christensen"
				};
				xw.writeStartElement("performers");
				for (String  performer : performers5) {
				  xw.writeStartElement("performer");
				  xw.writeCharacters(performer);
				  xw.writeEndElement();
				}
				xw.writeEndElement(); 
				xw.writeStartElement("discs");
				xw.writeCharacters("2");
				xw.writeEndElement();
				xw.writeStartElement("price");
				xw.writeCharacters("14.99");
				xw.writeEndElement(); 
				xw.writeEndElement();


				xw.writeEndElement();  // close the DVDS tag
				xw.writeEndDocument();
				xw.flush();
				xw.close(); 
		} catch  (XMLStreamException e) {
		      e.printStackTrace();
		} catch (IOException e)  {
		      e.printStackTrace();
		}
	}
}
