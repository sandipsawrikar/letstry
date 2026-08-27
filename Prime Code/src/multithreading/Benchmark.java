package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;

public class Benchmark {
    public static void main(String[] args) {
        long startTime, endTime;

        // Virtual Threads Benchmark
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                // Simulate some work
                try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }
        executor.shutdown();
        endTime = System.currentTimeMillis();
        System.out.println("Virtual Threads Execution Time: " + (endTime - startTime) + " ms");

        // CompletableFuture Benchmark
        startTime = System.currentTimeMillis();
        CompletableFuture<?>[] futures = new CompletableFuture<?>[10000];
        for (int i = 0; i < 10000; i++) {
            int taskNumber = i;
            futures[i] = CompletableFuture.runAsync(() -> {
                // Simulate some work
                try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }
        CompletableFuture.allOf(futures).join();
        endTime = System.currentTimeMillis();
        System.out.println("CompletableFuture Execution Time: " + (endTime - startTime) + " ms");
    }
}