package multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerExecutor {
    // Shared buffer with a maximum capacity of 5 items
    private static final int BUFFER_CAPACITY = 5;
    private static final BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(BUFFER_CAPACITY);

    // Atomic counters to safely track total items produced and consumed across threads
    private static final AtomicInteger totalProduced = new AtomicInteger(0);
    private static final AtomicInteger totalConsumed = new AtomicInteger(0);

    public static void main(String[] args) {
        // Create an ExecutorService managing a thread pool for both tasks
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit 2 Producer tasks to the executor
        executor.submit(new Producer());
        executor.submit(new Producer());

        // Submit 2 Consumer tasks to the executor
        executor.submit(new Consumer());
        executor.submit(new Consumer());

        // Let the simulation run for 5 seconds, then shut down gracefully
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(">>> Shutting down ExecutorService...");
        executor.shutdownNow();

        try {
            if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println(">>> All threads terminated successfully.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Display the final atomic tallies
        System.out.println("Final Stats -> Total Produced: " + totalProduced.get()
                + " | Total Consumed: " + totalConsumed.get());
    }

    /**
     * Producer Task
     */
    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // Atomically increment and get the next unique item ID
                    int item = totalProduced.incrementAndGet();

                    // .put() blocks automatically if the LinkedBlockingQueue is full
                    buffer.put(item);
                    System.out.println(Thread.currentThread().getName() + " [PRODUCED]: " + item
                            + " (Buffer Size: " + buffer.size() + ")");

                    // Simulate variable production time
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                // Allow the thread to exit cleanly upon shutdownNow()
                System.out.println(Thread.currentThread().getName() + " (Producer) interrupted.");
            }
        }
    }

    /**
     * Consumer Task
     */
    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // .take() blocks automatically if the LinkedBlockingQueue is empty
                    int item = buffer.take();

                    // Atomically increment the consumption count
                    totalConsumed.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + " [CONSUMED]: " + item
                            + " (Buffer Size: " + buffer.size() + ")");

                    // Simulate variable consumption time
                    Thread.sleep(600);
                }
            } catch (InterruptedException e) {
                // Allow the thread to exit cleanly upon shutdownNow()
                System.out.println(Thread.currentThread().getName() + " (Consumer) interrupted.");
            }
        }
    }
}
