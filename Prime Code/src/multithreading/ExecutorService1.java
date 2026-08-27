package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService1 {
    public static void main(String[] args) {

       /* ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<100; i++){
            executorService.execute(() -> {
                System.out.println("Executing task"+ Thread.currentThread().getName());
            });
        }
        executorService.shutdown();*/

        // 1. Create a custom ExecutorService
        ExecutorService customExecutor = Executors.newFixedThreadPool(3);

        System.out.println("[" + Thread.currentThread().getName() + "] Submitting asynchronous task...");

        CompletableFuture<Void> future=
                CompletableFuture.runAsync(()->{System.out.println("Running asynchronously on thread: "
                        + Thread.currentThread().getName());},customExecutor);

        System.out.println("[" + Thread.currentThread().getName() + "] Main execution finished.");
    }

    private static void simulateLongRunningTask() {
        try {
            System.out.println("[" + Thread.currentThread().getName() + "] Fetching data from remote source...");
            Thread.sleep(1500); // Simulate 1.5s latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
