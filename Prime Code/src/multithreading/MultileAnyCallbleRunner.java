package multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultileAnyCallbleRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        List<CallableTask> callableTasks = List.of(new CallableTask("Sachin"), new CallableTask("Rohit"), new CallableTask("Virat"), new CallableTask("Dhoni"),
                new CallableTask("SKY"), new CallableTask("Hardik"));
        String results = executorService.invokeAny(callableTasks);
        System.out.println(results);

        executorService.shutdown();

    }
}
