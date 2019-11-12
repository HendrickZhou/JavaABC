import java.io.*;

public class SortString
{
    public static void sortString(String[] str)
    {
        // insert sorting
        int len = str.length;
        for(int i = 1; i< len; i++)
        {
            int j = i-1;
            String cur_str = str[i];  
            while(j >= 0 && str[j].compareTo(cur_str) > 0)
            {
                str[j+1] = str[j];
                j--;
            }
            str[j+1] = cur_str;
        }
    }

    public static void printStrArr(String [] arr)
    {
        System.out.println("Sorted strings:");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }



    public static void main(String[] argv) throws IOException
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in),1);
        System.out.println("How many strings you want to sort?");
        int num_str = Integer.parseInt(stdin.readLine());
        System.out.println("Alright! Now input " + num_str + " lines of strings.");
        String [] input_lines = new String[num_str];
        for(int i = 0; i < num_str; i++)
        {
            input_lines[i] = stdin.readLine();
        }
        System.out.println("********Start sorting*********");
        sortString(input_lines);
        printStrArr(input_lines);
    }


}
