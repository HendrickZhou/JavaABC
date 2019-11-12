import java.io.*;
import java.util.EmptyStackException;

public class CharStack
{
  private char[] m_data;           // See Note #1 below
  
  private int m_ptr;
  
  public CharStack(int size)
  {
      m_ptr = 0;                   // Note #2
      m_data = new char[(size > 1 ? size : 10)]; 
  }
  
  public void push(char c)
  {
      if (m_ptr >= m_data.length) // Note #3
      {
         // Grow the array automatically
         char[] tmp = 
            new char[m_data.length * 2];
      
         System.arraycopy(m_data, 0, 
                          tmp, 0, 
                          m_data.length);
         m_data = tmp;
      }
      m_data[m_ptr++] = c;
  }
      
  public char pop()              // Note #4
  {
    if(m_ptr == 0)
    {
      throw new EmptyStackException();
    }
    return m_data[--m_ptr];
  }
  public boolean hasMoreElements()
  {
      return (m_ptr != 0);
  }
  
  // Note #5
  public static void main(String[] argv) 
      throws IOException
  {
      CharStack s = new CharStack(10);
      int i;
      int j = 0;
      while ( (i = System.in.read()) != -1 && j++ < 10)
      {
         s.push((char) i);
      }

      System.out.println("Outputting the Stack");
      while (true)
      {
        try
         {
          System.out.write(s.pop());}
         catch(EmptyStackException e)
         {
          System.out.println("\nStack is empty already!");
          System.out.println("Breaking the loop");
           break;
         }
      }
      System.out.println();
    }
}
