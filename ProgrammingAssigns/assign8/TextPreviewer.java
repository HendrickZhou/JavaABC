import java.net.URL;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;

public class TextPreviewer
{
	private static boolean isLegitURL(String path)
	{
		try{
	    	(new URL(path)).openStream().close();
	    	return true;
		} catch (Exception e) { }		
		return false;
	}
	private static boolean isLegitFile(String path)
	{
		try{
			Paths.get(path);
			return true;
		} catch (InvalidPathException ex) { }
        return false;
	}

	private static BufferedReader preprocess(String path)
	{
		
		if(isLegitFile(path))
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				return br;
			} catch(Exception e) { }
			finally{
				if(isLegitURL(path))
				{
					try {
						URL u = new URL(path);
						
						BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
						// System.out.println("check");
						return br;				
					} catch(Exception e) { }
				}
			}
		}
		throw new IllegalArgumentException("Invalid url or file path");
	}

	// both the number
	// range doesn't cover the last one
	private static int[] regulate_num(int lines, int max)
	{
		int[] range = new int[2];
		if(lines > max || lines == 0)
		{
			range[0] = 0;
			range[1] = max;
		}
		else if(lines < 0)
		{
			range[0] = max + lines;
			range[1] = max;
		}
		else
		{
			range[0] = 0;
			range[1] = lines;
		}
		return range;
	}

	private static void showLines(int line, ArrayList<String> lines)
	{
		int total_lines = lines.size();
		int[] line_range = regulate_num(line, total_lines);
		for(int i = line_range[0]; i < line_range[1]; i++)
		{
			String s = lines.get(i);
			System.out.println(s);
		}
	}

	public static void preview(String resource_name, int line)
	{
		try{
			BufferedReader br = preprocess(resource_name);
			try{

				// lets count the lines brutally
				ArrayList<String> lines = new ArrayList<String>();
				String s = null;
				int cnt;
				while((s = br.readLine()) != null)
				{
					// System.out.println(s);
					lines.add(s);
				}
				showLines(line, lines);



			} catch(Exception e)
			{
				return;
			}
			
		} catch(IllegalArgumentException e)
		{
			return;
		}
	}

	public static void main(String[] arg)
	{
		// String path = "/Users/zhouhang/Project/java/mod_assign/assign7/Ballon.java";
		String path = "http://www.gnu.org:80/licenses/gpl.txt";
		preview(path, -1);
	}
}