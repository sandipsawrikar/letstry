package multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {
    private AtomicInteger atomicInteger= new AtomicInteger(0);

    // Synchronized method prevents race conditions
    public  void increment() {
        //count++;
    }

    public  AtomicInteger getCount() {
          atomicInteger.getAndIncrement();
        return atomicInteger;
    }

    @Override
    public String toString() {
        return atomicInteger.toString()
                ;
    }
}

public class ThreadPoolSyncExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,  // Core pool size
                12,  // Maximum pool size
                1,  // Keep alive time (seconds)
                TimeUnit.SECONDS,  // Time unit for keep alive time
                new ArrayBlockingQueue<>(200)  // Task queue
        );

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 200; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is being executed by " + Thread.currentThread().getName());
              /* try {
                    Thread.sleep(5000);  // Simulating a task that takes 1 second to complete
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }*/
                System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
            });
        }
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if(!t.isDaemon())
                System.out.printf("Name: %-25s | State: %-12s",
                        t.getName(), t.getState());
        }
        // Gracefully shut down the executor after all tasks are completed
        executor.shutdown();
    }
}