import java.util.Stack; 
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.HashSet;


public class Bowler
{
	private String name;
	private int numGame;
	private Stack<String> gameTime;
	private Stack<Float> gameScore;
	private float aveScore;

	public Bowler(String name)
	{
		this.name = name;
		this.numGame = 0;
		this.aveScore = 0;
		this.gameTime = new Stack<String>();
		this.gameScore = new Stack<Float>();
	}

	public String getName()
	{
		return this.name;
	}

	public void addGame(float score)
	{
		numGame++;
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String curDateTime = formatter.format(LocalDateTime.now());
		gameTime.add(curDateTime);
		gameScore.add(score);
		aveScore = (aveScore*(numGame-1) + score)/numGame;
		System.out.println("Round" + numGame + '\t' + score + '\t' + curDateTime);
	}

	public void repr()
	{
		System.out.println("Name:" + this.name);
		System.out.println("Game times:" + this.numGame);
		System.out.println("average score:" + this.aveScore);
		System.out.println("Date and time of last game:" + getLastTime());
		System.out.println("Score of last game:" + getLastScore());
		System.out.println("-------------------------");
	}

	public String getLastTime()
	{
		return gameTime.peek();

	}
	public float getLastScore()
	{
		return gameScore.peek();
	}

	/* override method */
	@Override
	public int hashCode()
	{
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == null || !(obj instanceof Bowler)) return false;
		if(obj == this) return true;
		if(this.name.equals(((Bowler)obj).getName()))
		{
			System.out.println("Name collision detected! This game will not be recorded to board");
			return true;
		}
		else return false;
	}

	// for future dev
	public void clearGame()
	{
		gameTime.clear();
		gameScore.clear();
	}
}