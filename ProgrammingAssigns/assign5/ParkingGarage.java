import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParkingGarage
{
    final static public int maxWeight = 25000;
    final static public int maxVehNum = 20;
    private String name;
    private int curVehNum;
    private int curWeight;
    // HashSet<Vehicle> parkingLot;
    ParkingGarage()
	{
        this.name = "Cal Parking";
		this.curVehNum = 0;
        this.curWeight = 0;
        // parkingLot = new HashSet<Vehicle>();
        reprGarageInfo();
	}

    ParkingGarage(String name)
    {
        this.name = name;
        this.curVehNum = 0;
        this.curWeight = 0;
        // parkingLot = new HashSet<Vehicle>();
        reprGarageInfo();
    }

    private boolean isOverLimit(int w)
    {
        if(curWeight + w > maxWeight || curVehNum + 1 > maxVehNum)
            return true;
        else
            return false;
    }

    public void reprGarageInfo()
    {
        System.out.println("****************************");
        System.out.println("* Garage " + this.name + " up and running");
        System.out.println("* Maximum Valid Parking Plots: " + maxVehNum);
        System.out.println("* Maximum Weight Capability: " + maxWeight);
        System.out.println("****************************");
    }

    public String getGarageName()
    {
        return this.name;
    } 

    public boolean carIn(Vehicle v, String carName)
    {
    /**
    * return value means if the garage needs to close down
    */
        int weight = getCarInfo(v, carName);
        if(isOverLimit(weight))
        {
            System.out.println("Can't get in, garage over limit!");
            this.reprGarageCap();
        }
        else
        {
            System.out.println("Parking successfully!");
            curWeight += v.getWeightInPounds();
            curVehNum++;
            this.reprGarageCap();
            if(this.curVehNum == this.maxVehNum || this.maxWeight - this.curWeight < 1000)  // magic number here haha
            {
                System.out.println("****************************");
                System.out.println("* Garage " + this.name + " full, now closing service");
                System.out.println("****************************");    
                return true;           
            }
        }
        return false;
    }

    private int getCarInfo(Vehicle v, String carName)
    {
        int w = v.getWeightInPounds();
        System.out.println("* <infomation>\t*\t");
        System.out.println("* Model:\t" + ": " + carName + "\t*");
        System.out.println("* Weight:\t" + ": " + w + "\t\t*");
        return w;
    }
    public void reprGarageCap()
    {
        int remainLot = this.maxVehNum - this.curVehNum;
        int remainWeight = this.maxWeight - this.curWeight;
        System.out.println("Remaining parking lot number:\t" + remainLot);
        System.out.println("Remaining weight capability:\t" + remainWeight + " Pounds");
        System.out.println("-------------------------");
    }

    public static void parkingSim(ParkingGarage park)
    {
        SaturnSL1 ss = new SaturnSL1();
        HondaCivic hc = new HondaCivic();
        MercedesC230 mc = new MercedesC230();
        ChevyS10 cs = new ChevyS10();
        SubaruOutback so = new SubaruOutback();

        Random rand = new Random();

        while(true)
        {
            int rndIdx = rand.nextInt(5);
            int rndSec = rand.nextInt(3);
            rndSec++;
            boolean result = true;
            switch(rndIdx)
            {
                case 0:
                    result = park.carIn(ss, "SaturnSL1");
                    break;

                case 1:
                    result = park.carIn(hc, "HondaCivic");
                    break;

                case 2:
                    result = park.carIn(mc, "MercedesC230");
                    break;

                case 3:
                    result = park.carIn(cs, "ChevyS10");
                    break;

                case 4:
                    result = park.carIn(so, "SubaruOutback");
                    break;
            }
            if(result == true)
            {
                break;
            }
            try
            {
                TimeUnit.SECONDS.sleep(rndSec);
            }
            catch(InterruptedException e)
            {
                System.out.println("sleep got interrupted");
            }
        }

    }

    // public boolean carOut()
    // {
    //     return true;
    // }
  
	public static void main(String[] args)
	{
        ParkingGarage Dwinelle = new ParkingGarage("Dwinelle");
        parkingSim(Dwinelle);
        ParkingGarage Sproul = new ParkingGarage("Sproul");
        parkingSim(Sproul);
	}
}

interface Domestic { }
interface Import { }
interface Japanese extends Import { }
interface German extends Import { }
interface Detroit extends Domestic { }
interface SpringHill extends Domestic { }
   
interface Vehicle
{
	int getWeightInPounds();
}

interface Automobile extends Vehicle
{
	static final int weight = 1000;
}
interface LargeAutomobile extends Vehicle
{
	static final int weight = 2500; 
}

interface Sedan extends Automobile { }
interface Van extends LargeAutomobile {}
interface Truck extends LargeAutomobile { }
interface Compact extends Automobile { }
interface SportsUtilityVehicle extends Truck, Van { }
   
class SaturnSL1 implements SpringHill, Sedan
{
	public int getWeightInPounds()
	{
		return weight;
	}	
}
class HondaCivic implements Japanese, Compact
{
	public int getWeightInPounds()
	{
		return weight;
	}	
}
class MercedesC230 implements German, Sedan
{
	public int getWeightInPounds()
	{
		return weight;
	}
}
class ChevyS10 implements Detroit, Truck 
{
	public int getWeightInPounds()
	{
		return weight;
	}
}
class SubaruOutback implements Japanese, SportsUtilityVehicle 
{
	public int getWeightInPounds()
	{
		return weight;
	}
}
