package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTHreadedExecuterServiceRunner {

    public static void main(String[] args)  {
        ExecutorService  executorService= Executors.newSingleThreadExecutor();
        executorService.execute(new Task1());
        executorService.execute(new Thread(new Task2()));

        executorService.shutdown();

        System.out.println(" Task3 kicked off");
        for (int i=300;i<399;i++)
            System.out.print(i+" ");
        System.out.println(" Task3 done");

    }
}
