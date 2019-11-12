import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;

class Test
{
	private static void sleep(int time)
	{
        try
        {
            TimeUnit.SECONDS.sleep(time);
        }
        catch(InterruptedException e)
        {
            System.out.println("sleep got interrupted");
        }
	}

	public static Bowler newPlayer(String name)
	{
		System.out.println("**Starting to record the game of player " + name + "**");
        Random rand = new Random();
		Bowler b = new Bowler(name);
		for(int i = 0 ; i< 5; i++)
		{
			b.addGame(10*(rand.nextFloat()+1));
			sleep(rand.nextInt(3));
		}
		// b.repr();
		return b;
	}

	// public static getD()

	public static void main(String[] argv)
	{
		// BowlerBoard board = new BowlerBoard();
		// Bowler bowler1 = newPlayer("Rick");
		// Bowler bowler2 = newPlayer("Morty");
		// Bowler bowler3 = newPlayer("Noobmaster69");
		// Bowler dup = newPlayer("Rick");

		// System.out.println("Adding Rick to board");
		// board.add(bowler1);
		// System.out.println("Adding Morty to board");
		// board.add(bowler2);
		// System.out.println("Adding Noobmaster69 to board");
		// board.add(bowler3);
		// System.out.println("Adding Rick to board");
		// board.add(dup);


		// System.out.println("********************************\nListing the "
		// 	+ "bowler score board!\n********************************");
		// Iterator it = board.iterator();
		// while(it.hasNext())
		// {
		// 	Bowler b = (Bowler) it.next();
		// 	b.repr();
		// }
		// System.out.println("number of bowler on board:" + board.size());
		// int [][][][] arr = {{{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}}};
		// System.out.println(arr[0][0][0]);
		// System.out.println(arr[0][0].length);
		// System.out.println(arr[0].length);
		// System.out.println(arr.length);
		byte b0 = 0;
		byte b1 = 1;
		int a = b0 + b1<<8;
		System.out.println(a);
	}
}