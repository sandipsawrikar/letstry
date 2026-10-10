package multithreading;

public class Demo3 {
    public static void main(String[] args) {
        Box box = new Box();
        Box box2 = new Box();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 2000; i++) {
                try {
                    Thread.sleep(1);
                    box.producer(i);
                } catch (Exception e) {
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 2000; i++) {
                try {
                    Thread.sleep(1);
                    box.consumer();
                } catch (Exception e) {
                }
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 2000; i++) {
                try {
                    Thread.sleep(1);
                    box2.producer(i);
                } catch (Exception e) {
                }
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 2000; i++) {
                try {
                    Thread.sleep(1);
                    box2.consumer();
                } catch (Exception e) {
                }
            }
        });

        t1.start();
        t2.start();
         t3.start();
          t4.start();
    }
}

class Box {
    Integer item;
    Boolean flag = false;

    synchronized void producer(int value) throws InterruptedException {
        while (flag == true) {
            wait();
        }

        item = value;
        flag = true;
        System.out.println("Producer produces " + item);

        notify();
    }

    synchronized void consumer() throws InterruptedException {
        while (flag == false) {
            wait();
        }

        System.out.println("Consumer consumes " + item);
        item = null;
        flag = false;
        notify();
    }
}