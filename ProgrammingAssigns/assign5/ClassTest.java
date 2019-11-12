public class ClassTest
{

	static void testPt1()
	{
		SaturnSL1 sl = new SaturnSL1( );
		HondaCivic hc = new HondaCivic( );
		// Japanese jp = new Japanese( );	// abstract class can't be initlized
		Japanese jp = null;
		German gr = new MercedesC230( );
		// ChevyS10 cs = new Truck( );	// abstract class can't be initlized
		ChevyS10 cs = null;
		SubaruOutback sb = new SubaruOutback( );	
		Domestic dm = sl;	
		// dm = hc;	// incompatible types: HondaCivic cannot be converted to Domestic
		dm = null;
		// dm = (Domestic) hc; // runtime error
		dm = cs;
		dm = (Domestic) cs;	
		Import im = sb;	
		// gr = im; // incompatible types: Import cannot be converted to German
		gr = null;	
		// gr = (German) im; // runtime error	
		// jp = im; // incompatible types: Import cannot be converted to Japanese
		jp = null;	
		// jp = (German) im; // incompatible types: German cannot be converted to Japanese
		jp = null;
		jp = (Japanese) im;	
		// Automobile a = cs; // incompatible types: ChevyS10 cannot be converted to Automobile
		Automobile a = null;
		a = hc;		
	}

	public static void main(String [] argv)
	{
		testPt1();
	}
}

interface Domestic { }
interface Import { }
interface Japanese extends Import { }
interface German extends Import { }
interface Detroit extends Domestic { }
interface SpringHill extends Domestic { }
   
interface Vehicle { }
interface Automobile extends Vehicle { }
interface LargeAutomobile extends Vehicle { }
interface Sedan extends Automobile { }
interface Van extends LargeAutomobile { }
interface Truck extends LargeAutomobile { }
interface Compact extends Automobile { }
interface SportsUtilityVehicle extends Truck, Van { }
   
class SaturnSL1 implements SpringHill, Sedan { }
class HondaCivic implements Japanese, Compact { }
class MercedesC230 implements German, Sedan { }
class ChevyS10 implements Detroit, Truck { }
class SubaruOutback implements Japanese, SportsUtilityVehicle { }
