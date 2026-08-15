package multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureExample2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "One");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Two");

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2);

        all.thenRun(() -> {
            System.out.println(f1.join());
            System.out.println(f2.join());
        });

        CompletableFuture
                .supplyAsync(() -> "data1")
                .thenAccept(data -> System.out.println("Got: " + data));


            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                if (new Random().nextBoolean()) {
                    throw new RuntimeException("Unexpected Error!");
                }
                return "Success!";
            });
            future.handle((result, ex) -> {
                if (ex != null) {
                    System.out.println("Error occurred: " + ex.getMessage());
                    return "Default Value";
                }
                return result;
            }).thenAccept(System.out::println);

        ExecutorService customExecutor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Unexpected Error!");
            }
            return "Success!";
        });
        future2.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Error occurred: " + ex.getMessage());
                return "Default Value";
            }
            return result;
        }).thenAccept(System.out::println);
    }
            

}