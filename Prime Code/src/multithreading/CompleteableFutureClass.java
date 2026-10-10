package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteableFutureClass {

    public static String getFirstName()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Sandip ";
    }
    public static String getMiddleName()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Sanjayrao ";
    }
    public static String getLastName() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Sawrikar ";
    }

    static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(CompleteableFutureClass::getFirstName);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(CompleteableFutureClass::getMiddleName);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(CompleteableFutureClass::getLastName);
        System.out.println("********");
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.join();
        System.out.println("^^^");
        CompletableFuture<String> fullNameFuture = allFutures.thenApply(v -> {
            // join() extracts the results without throwing checked exceptions
            String first = future1.join();
            String middle = future2.join();
            String last = future3.join();

            return String.format("%s %s %s", first, middle, last);
        });

        String fullName = fullNameFuture.get();
        System.out.println("Full Name: " + fullName);


    }
}
