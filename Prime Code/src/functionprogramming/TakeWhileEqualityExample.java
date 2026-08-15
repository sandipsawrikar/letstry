package functionprogramming;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TakeWhileEqualityExample {
    public static void main(String[] args) {

        // A stream where the target value (5) appears sequentially, breaks, and appears again
        Stream.of(5, 5, 5, 4, 5, 5)
                .takeWhile(num -> num == 5)
                .forEach(System.out::println);
    }
}