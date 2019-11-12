public class ReverseString
{
    public static String reverse(String s)
    {
        if(s.length() <= 1){
            return s;
        }
        String leftStr = Character.toString(s.charAt(0));
        String rightStr = s.substring(1);
        String RrightStr = reverse(rightStr);
        return RrightStr + leftStr;
    }

    public static void main(String[] argv)
    {
        String testStr = "hello_world";
        String testStr_short = "Y";
        String testStr_empty = "";
        
        System.out.println("Original strings:");
        System.out.println(testStr);
        System.out.println(testStr_short);
        System.out.println(testStr_empty);
        System.out.println("***************");
        System.out.println("After reversing");
        System.out.println("***************");
        String result = reverse(testStr);
        System.out.println(result);
        result = reverse(testStr_short);
        System.out.println(result);
        result = reverse(testStr_empty);
        System.out.println(result);

    } 
}
