package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,3,2,3,2,5,4);
        Optional<Integer> first = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        first.ifPresent(System.out::println);
    }
}
