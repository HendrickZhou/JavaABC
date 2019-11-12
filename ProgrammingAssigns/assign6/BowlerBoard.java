import java.util.HashSet;
import java.util.Iterator;

public class BowlerBoard
{
	private HashSet<Bowler> bowlerBoard;

	BowlerBoard()
	{
		bowlerBoard = new HashSet<Bowler>();
	}

	// add instinct element to the Board
	public boolean add(Bowler b)
	{
		return bowlerBoard.add(b);
	}
	public boolean remove(Bowler b)
	{
		return bowlerBoard.remove(b);
	}
	public int size()
	{
		return bowlerBoard.size();
	}
	public void clear()
	{
		bowlerBoard.clear();
	}
	public boolean isEmpty()
	{
		return size() == 0 ? true : false;
	}
	public Iterator iterator()
	{
		return bowlerBoard.iterator();
	}
	public boolean contains(Bowler b)
	{
		return bowlerBoard.contains(b);
	}	
}



