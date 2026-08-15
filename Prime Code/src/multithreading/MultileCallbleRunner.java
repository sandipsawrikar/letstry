package multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultileCallbleRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        List<CallableTask> callableTasks = List.of(new CallableTask("Sachin"), new CallableTask("Rohit"), new CallableTask("Virat"), new CallableTask("Dhoni"),
                new CallableTask("SKY"), new CallableTask("Hardik"));
       List< Future<String>> results = executorService.invokeAll(callableTasks);

       for(Future<String> result : results){
           System.out.println(result.get());
       }
        executorService.shutdown();

    }
}
