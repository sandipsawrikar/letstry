package multithreading;

class ThreadJoin extends Thread {
    public void run() {
        for (int j = 0; j < 2; j++) {
            try {
                Thread.sleep(300); // Sleep for 300 milliseconds
                System.out.println("The current thread name is: " + j);
            } catch (Exception e) {
                System.out.println("The exception has been caught: " + e);
            }
            //System.out.println(j);
        }
    }
}

public class ThreadJoinExample {
    public static void main(String args[]) {
        ThreadJoin th1 = new ThreadJoin();
        ThreadJoin th2 = new ThreadJoin();
        ThreadJoin th3 = new ThreadJoin();



        try {

            th1.start();
            th1.join();
        } catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

        th2.start();

        try {
            System.out.println("The current thread name is: " +th1.getName());
            th2.join();
        } catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

        th3.start();
    }
}