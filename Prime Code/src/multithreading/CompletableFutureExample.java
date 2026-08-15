package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {

        // 1. Run a background task that returns a value
        CompletableFuture<String> futureTask = CompletableFuture.supplyAsync(() -> {
            simulateLongRunningTask();
            return "Data fetched successfully";
        });

        // 2. Chain a transformation step (Non-blocking)
        CompletableFuture<String> processedTask = futureTask.thenApply(result -> {
            return result + " and safely processed!";
        });

        // 3. Handle errors gracefully if they occur during the pipeline
        CompletableFuture<String> safeTask = processedTask.exceptionally(exception -> {
            return "Fallback fallback data: " + exception.getMessage();
        });

        // 4. Consume the final result once it finishes
        safeTask.thenAccept(finalResult -> {
            System.out.println("Callback Output: " + finalResult);
        });

        // Prevent the main thread from exiting immediately before the background work completes
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void simulateLongRunningTask() {
        try {
            TimeUnit.SECONDS.sleep(1); // Simulates a database query or network API call
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}