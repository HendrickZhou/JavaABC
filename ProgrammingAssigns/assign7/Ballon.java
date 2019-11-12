public class Ballon
{
	final private int max_pressure = 100;
	private int pressure;
	private boolean good;
	public Ballon()
	{
		this.pressure = 0;
		this.good = true;
		System.out.println(String.format("the max pressure is %d", this.max_pressure));
	}

	public void inflate(int p)
	{
		if(good)
		{		
			if(this.max_pressure < p + this.pressure)
			{
				// I know this exception is not the best choice
				// but it should work
				this.pressure = 0;
				this.good = false;
				throw new IllegalArgumentException("Too much pressure");
			}
			this.pressure += p;
			System.out.println(String.format("Wow the ballon is inflating, this pressure is %s now.", this.pressure));
		}
		else
		{
			System.out.println("Sorry this ballon is wasted");
		}
	}
	public static void main(String[] arg)
	{
		Ballon b = new Ballon();
		int[] inf = {50,40,9,2,10,10,10};
		for(int i = 0; i < inf.length; i++)
		{
			try
			{
				b.inflate(inf[i]);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("the ballon is blowed off");
			}
			finally
			{
				continue;
			}
		}
	}
}