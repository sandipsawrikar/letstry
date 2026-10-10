package Java8;

public class Test implements  t1, t12{
    static void main(String[] args) {
        //int [] arr= new int [Integer.MAX_VALUE];
        System.out.println(Integer.MAX_VALUE);


    }
}

interface  t1{
    default void test(){
        System.out.println(Integer.MAX_VALUE);
    }
}
interface  t12{

    // Public default method 1
    default void logInfo(String message) {
        log("INFO", message);
    }

    // Public default method 2
    default void logError(String message) {
        log("ERROR", message);
    }

    // Private helper method - Encapsulated and hidden from external classes
    private void log(String level, String message) {
        System.out.println("[" + level + "] " + System.currentTimeMillis() + ": " + message);
    }

    // Private static helper - Can be called from public static methods
    private static void printSystemBanner() {
        System.out.println("--- LOGGING SYSTEM ACTIVE ---");
    }
}