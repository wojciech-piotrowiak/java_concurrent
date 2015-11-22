import operations.HelloOperation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolTest
{
	public static void main(String... blablabla) throws ExecutionException, InterruptedException
	{
		System.out.println("ThreadPool example");
		System.out.println("Start thread number: "+Thread.activeCount());
		ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Before submit thread number: "+Thread.activeCount());
        System.out.println("Start time: "+System.nanoTime());
		for (int a = 0; a < 50; a++)
		{
            executorService.submit(new HelloOperation());
		}
	}
}

