package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {

    private static final AtomicInteger sharedCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // Create a pool of 5 threads to run tasks concurrently
        ExecutorService executor = Executors.newFixedThreadPool(15);

        // Submit 1000 tasks that increment the counter
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                // Safely read, increment, and write in one atomic action
              sharedCounter.incrementAndGet();
            });
        }

        // Shut down executor and wait for tasks to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Will consistently and accurately print 1000
        System.out.println("Final Counter Value: " + sharedCounter.get());
    }
}
