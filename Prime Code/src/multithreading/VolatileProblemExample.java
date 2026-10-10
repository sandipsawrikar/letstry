package multithreading;
public class VolatileProblemExample {
    public static void main(String[] args) {
        Thread sumThread = new Thread(() -> {
            int sum = 5 + 10;
            System.out.println("Sum: " + sum);
        }, "SumWorker-Thread");

        sumThread.start();

        // Print all active threads in the current JVM process
        System.out.println("--- All Active Threads ---");
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if(!t.isDaemon())
            System.out.printf("Name: %-25s | State: %-12s | Daemon: %s%n",
                    t.getName(), t.getState(), t.isDaemon());
        }
    }
}