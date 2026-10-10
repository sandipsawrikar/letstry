package multithreading;


import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws InterruptedException {
        System.out.println("Hello "+name);
        Thread.sleep(2000);
        return "Hello " +name;
    }
}
public class CallbleRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (long i= 0;i<1000000000000l;i++) {
            Future<String> welcomeFuture = executorService.submit(new CallableTask("Sandip"));
            // System.out.println("\nnew CallableTask(\"Sandip\") completed");
            welcomeFuture.get();
            //System.out.println();}
        }
       System.out.print("\n main completed");
        executorService.shutdown();

    }
}
