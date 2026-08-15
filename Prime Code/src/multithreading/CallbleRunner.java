package multithreading;


import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10);
        return "Hello " +name;
    }
}
public class CallbleRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
     Future<String> welcomeFuture = executorService.submit(new CallableTask("Sandip"));
        System.out.println("\nnew CallableTask(\"Sandip\") completed");
        System.out.println(welcomeFuture.get());
     System.out.print("\n main completed");
        executorService.shutdown();

    }
}
