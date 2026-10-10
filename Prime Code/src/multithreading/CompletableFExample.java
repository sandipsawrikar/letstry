package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFExample {
    static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(s -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return s.length();
        });

        transformedFuture.thenAccept(length -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Length of Hello: " + length);
        });
        System.out.println("end of main" );
    }
}
