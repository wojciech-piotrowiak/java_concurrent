import operations.LongOperation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTest {

    public static void main(String ... blablabla) throws ExecutionException, InterruptedException {
        callableExample();
        cancelExample();
    }

    private static void callableExample() throws InterruptedException, ExecutionException {
        System.out.println("Callable example");
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        System.out.println("Before submit");
        final Future<String> submit = executorService.submit(new CallMeMaybe());
        System.out.println("After submit+before get");
        System.out.println("Is done? : "+submit.isDone());
        System.out.println("After get: " + submit.get());
        System.out.println("Is done? : "+submit.isDone());
        System.out.println("---------------------------------");
    }

    private static void cancelExample() throws InterruptedException, ExecutionException {
        System.out.println("Cancel example");
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        System.out.println("Before submit");
        final Future<String> submit = executorService.submit(new CallMeMaybe());
        System.out.println("After submit+before cancel");
        submit.cancel(true);
        System.out.println("Is cancelled? : "+submit.isCancelled());
        //will throw CancellationException!
        //System.out.println("After get: " + submit.get());
    }
}

class CallMeMaybe implements Callable<String>
{
    @Override
    public String call() throws Exception {
        new LongOperation().run();
        return "CallMeMaybe";
    }
}