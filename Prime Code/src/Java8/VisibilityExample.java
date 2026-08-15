package Java8;


public class VisibilityExample {
    // Thread-unsafe
    private volatile boolean running = true;

    void start() {
        System.out.println("*********!");
        new Thread(() -> {
            while (running) {
             System.out.println("Running!");
            }
            System.out.println("Stopped!");
        }).start();
    }

    // Change may not be visible to other thread
    void stop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityExample t = new VisibilityExample();
        t.start();

        // Short pause before stopping
        Thread.sleep(2);

        // Thread may not see this without volatile
        t.stop();
    }
}