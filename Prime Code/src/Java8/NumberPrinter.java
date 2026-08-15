package Java8;

class NumberPrinter implements Runnable {
    boolean keepRunning = true;
    // 2. Override the run() method to define the thread's task
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            if(keepRunning)
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            if(Thread.currentThread().getName().equalsIgnoreCase("Thread-A")){
                keepRunning=false;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        // 3. Create an instance of your Runnable class
        NumberPrinter task = new NumberPrinter();

        // 4. Pass the Runnable object to a new Thread instance
        Thread thread1 = new Thread(task, "Thread-A");
        Thread thread2 = new Thread(task, "Thread-B");

        // 5. Start the threads
        thread1.start();
        thread2.start();
    }
}

