package multithreading;

public class CounterExample {
     static Counter counter = new Counter();

    static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if (Thread.currentThread().getState().equals(Thread.State.BLOCKED)) {
                    System.out.println("blocked T1");
                }
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if (Thread.currentThread().getState().equals(Thread.State.BLOCKED)) {
                    System.out.println("blocked T2");
                }
                counter.increment();
            }
        });

        thread.start();
        thread2.start();
            thread.join();
            thread2.join();
        System.out.println("final value " + counter.getCounter());

    }
}

class Counter {

    int i = 0;

    synchronized void increment() {
        i++;
    }

    int getCounter() {
        return i;
    }

}