package Java8;

import java.util.*;

public class LongestString {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("Java","SpringBoot","API"));
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        max.ifPresent(System.out::println);

    }
}
