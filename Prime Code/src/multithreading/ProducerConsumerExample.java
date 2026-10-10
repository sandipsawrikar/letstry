package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        // Shared buffer with a maximum capacity of 3
        SharedBuffer buffer = new SharedBuffer(3);

        // Producer thread
        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    buffer.produce(value++);
                    Thread.sleep(500); // Simulate time taken to produce
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "Producer");

        // Consumer thread
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    buffer.consume();
                    Thread.sleep(1000); // Simulate time taken to consume (slower)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}

class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Synchronized method locks the 'this' instance
    public synchronized void produce(int item) throws InterruptedException {
        // 1. ALWAYS use a while loop to protect against spurious wakeups
        while (queue.size() == capacity) {
            System.out.println(Thread.currentThread().getName() + " buffer full. Waiting...");
            wait(); // Releases the lock and pauses the producer thread
        }

        queue.add(item);
        System.out.println("Produced: " + item + " | Buffer Size: " + queue.size());

        // 2. Notify the waiting consumer thread that data is available
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        // 1. ALWAYS use a while loop to protect against empty buffer wakeups
        while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " buffer empty. Waiting...");
            wait(); // Releases the lock and pauses the consumer thread
        }

        int item = queue.poll();
        System.out.println("Consumed: " + item + " | Buffer Size: " + queue.size());

        // 2. Notify the waiting producer thread that space is available
        notifyAll();
        return item;
    }
}
