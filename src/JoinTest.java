public class JoinTest
{

	public static void main(String... input) throws InterruptedException {
		LongOperation lo = new LongOperation();
		Thread joinThread = new Thread(lo);

        System.out.println("Before start");

        joinThread.start();

        System.out.println("After start");
        System.out.println("Thread alive: "+joinThread.isAlive());

        joinThread.join();

        System.out.println("Thread alive: "+joinThread.isAlive());
        System.out.println("Joined after calculation is done");

	}
}

class LongOperation implements Runnable
{
	@Override
	public void run()
	{
		int counter = 0;
		for (long a = 0; a < 1_000_000_000; a++)
		{
            counter+=a;
		}
	}

}
