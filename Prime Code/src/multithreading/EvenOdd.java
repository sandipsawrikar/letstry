package multithreading;


import java.util.concurrent.*;

class Even implements Callable {
    int evenCount = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 1; i < 1000; i++) {
            if (i % 2 == 0) {
                evenCount += i;
            }
        }
        System.out.println("evenCount"+evenCount);
        return evenCount;
    }
}

class Odd implements Callable {
    int oddCount = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 1; i < 1000; i++) {
            if (i % 2 != 0) {
                oddCount += i;
            }
        }
        System.out.println("oddCount"+ oddCount);
        return oddCount;
    }
}

public class EvenOdd {
    static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main thread start ");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long startTimeL = System.nanoTime();
        Future<Integer> future1 = executorService.submit(new Even());
        Future<Integer> future2 = executorService.submit(new Odd());
        System.out.println(future1.get());
        System.out.println(future2.get());
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if(!t.isDaemon())
                System.out.printf("Name: %-25s | State: %-12s",
                        t.getName(), t.getState());
        }
        executorService.shutdown();
        /*even.start();
        odd.start();*/

        long endTimeL = System.nanoTime();

        long l2Time = endTimeL - startTimeL;

        System.out.println("totaltime"+l2Time);
        System.out.println("Main thread end ");

    }
}
