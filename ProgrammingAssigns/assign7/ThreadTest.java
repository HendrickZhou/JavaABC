import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadTest extends Thread
{
	public static void main(String[] arg)
	{
	    VarHolder data = new VarHolder();
	    Thread sender = new Thread(new Sender(data));
	    Thread receiver = new Thread(new Receiver(data));
	    sender.start();
	    receiver.start();
	}

}

class Sender implements Runnable
{
	Random randint = new Random();
	VarHolder holder;
	Sender(VarHolder holder)
	{
		this.holder = holder;
	}
	public void run()
	{
		while(true)
		{
			int next = randint.nextInt(10)+1;
			System.out.println(String.format("Sending: %d", next));
			holder.var_setter(next);

            try{
                TimeUnit.SECONDS.sleep(randint.nextInt(3));
            }
            catch(InterruptedException e){
                System.out.println("sleep got interrupted");
            }
		}

	}
}

class Receiver implements Runnable
{
	Random randint = new Random();
	VarHolder holder;
	Receiver(VarHolder holder)
	{
		this.holder = holder;
	}
	public void run()
	{
		while(true)
		{
			holder.var_getter();

            try{
                TimeUnit.SECONDS.sleep(randint.nextInt(3));
            }
            catch(InterruptedException e){
                System.out.println("sleep got interrupted");
            }
		}
	}
}


class VarHolder
{
	int var;
	public synchronized void var_setter(int v)
	{
		try{
			while(this.var != -1){
				notify();
				wait();
			}
		} catch(InterruptedException e) { }

		this.var = v;
		notify();
	}

	public synchronized void var_getter()
	{
		try{
			while(this.var == -1){
				notify();
				wait();
			}
		} catch(InterruptedException e) { }
		System.out.println(this.var);
		this.var = -1;
		notify();
	}
}