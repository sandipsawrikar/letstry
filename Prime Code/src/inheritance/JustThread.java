package inheritance;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class JustThread {
    static void main(String[] args) throws ExecutionException, InterruptedException {

        AtomicInteger counter = new AtomicInteger();
       try(ExecutorService executorService = Executors.newFixedThreadPool(2)) {

           executorService.execute(() -> {
               System.out.println("First thread");
               counter.getAndIncrement();
           });
           executorService.execute(() -> {
               System.out.println("Second thread");
               counter.getAndIncrement();
           });
           executorService.execute(() -> {
               System.out.println("Third thread");
               counter.getAndIncrement();
           });
          Future future= executorService.submit(() -> {
               System.out.println("Fourth thread");
              counter.getAndIncrement();
           });

           System.out.println("Main thread");
           System.out.println(future.get() +""+counter);
       }

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5,7,9);
        Integer reduce = nums.stream().filter(n -> n % 2 != 0).reduce(0, Integer::sum);
        System.out.println(reduce);
        Stream<Integer> stream = nums.stream();
        stream.distinct().forEach( System.out::println); stream.distinct().forEach( System.out::println);

    }
}
