package multithreading;
public class EvenOddPrinter{

    // Starting counter
    //will force all threads to update and use the latest copy of this counter, and not use locally cached copies
     int counter = 1;

    int limit;

    EvenOddPrinter (int limit) {this.limit = limit;}

    //function to print odd numbers
    public synchronized void printOddNum () {
        while(counter<=limit) {
            if(counter%2 == 1) { //counter is odd, print it
                // remove thread name and use System.out.print() to print in one line, as per the sample output format
                System.out.println(Thread.currentThread().getName()+": "+counter);
                counter++;
                System.out.println(this);
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Function to print even numbers
    public synchronized void printEvenNum () {
        while (counter<=limit) {
            if(counter%2 == 0) { //counter is even, print it
                // remove thread name and use System.out.print() to print in one line, as per the sample output format
                System.out.println(Thread.currentThread().getName()+": "+counter);
                counter++;System.out.println(this);

                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        EvenOddPrinter printer = new EvenOddPrinter (10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printOddNum();
            }
        });

        t1.setName("Odd"); // for clearer verification

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printEvenNum();
            }
        });

        t2.setName("Even"); // for clearer verification

        t1.start();
        t2.start();
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if(!t.isDaemon())
                System.out.printf("Name: %-25s | State: %-12s",
                        t.getName(), t.getState());
        }
    }
}
