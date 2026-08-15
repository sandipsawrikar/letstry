package multithreading;


class Task1 extends Thread {
    public void run(){
        //Task1
        System.out.println(" Task1 started");
        for (int i=100;i<199;i++)
            System.out.print(i+" ");
        System.out.println(" Task1 done");
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println(" Task2 started");
        for (int i=200;i<299;i++)
            System.out.print(i+" ");
        System.out.println(" Task2 done");
    }
}
public class ThreadBasicRunner {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(" Task1 kicked off");
        Task1 task1 = new Task1();
        task1.setPriority(10);
        task1.start();

        System.out.println(" Task2 kicked off");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(1);
        task2Thread.start();

        task1.join();
        task2Thread.join();

        System.out.println(" Task3 kicked off");
        for (int i=300;i<399;i++)
            System.out.print(i+" ");
        System.out.println(" Task3 done");
    }

}
