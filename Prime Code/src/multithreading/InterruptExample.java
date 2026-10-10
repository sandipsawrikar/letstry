package multithreading;

public class InterruptExample {
    static void main(String[] args) throws InterruptedException {

        // Capture a reference to the main thread
        Thread mainThread = Thread.currentThread();

        // Create a monitor thread to check the main thread's state
        Thread monitorThread = new Thread(() -> {
            try {
                // Give the main thread a moment to enter the sleep state
                Thread.sleep(1000);
                System.out.println("Main thread state: " + mainThread.getState());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the monitor thread
        monitorThread.start();

        // Put the main thread into a TIMED_WAITING state
        Thread.sleep(2000);
        System.out.println("monitorThread thread state: " + monitorThread.getState());
        // Wait for the monitor thread to finish
        monitorThread.join();
        System.out.println("Main thread finished.");
    }
}
