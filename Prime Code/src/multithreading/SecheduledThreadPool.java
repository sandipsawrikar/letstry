package multithreading;

import java.util.concurrent.*;

public class SecheduledThreadPool {

    static void main(String[] args) {

        // 1. Create a thread pool that can schedule commands to run after a given delay, or periodically
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Define a simple task
        Runnable periodicTask = () -> {
            System.out.println("Periodic task executed at: " + System.currentTimeMillis() / 1000);
        };

        Runnable oneTimeTask = () -> {
            System.out.println("One-time delayed task executed!");
        };

        System.out.println("Submitting tasks at: " + System.currentTimeMillis() / 1000);

        // 2. Schedule a periodic task: starts after 1 second, repeats every 2 seconds
        ScheduledFuture<?> periodicHandle = scheduler.scheduleAtFixedRate(
                periodicTask,
                1,          // Initial delay
                2,          // Period between successive executions
                TimeUnit.SECONDS
        );

        // 3. Schedule a one-time task to execute after 5 seconds
        scheduler.schedule(
                oneTimeTask,
                5,          // Delay
                TimeUnit.SECONDS
        );

        // 4. Schedule a cancellation mechanism: cancel the periodic task and shut down after 10 seconds
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            periodicHandle.cancel(true); // Cancel the periodic task
            scheduler.shutdown();        // Reclaim thread resources
        }, 10, TimeUnit.SECONDS);
    }


}
