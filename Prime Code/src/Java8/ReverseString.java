package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Java8";
        String reduced = str.chars().mapToObj(c -> String.valueOf((char)c)).
                reduce("", (a, b) -> b + a);
        System.out.println(reduced);

        //find duplicate charecter
        String programming = "programming";

        Map<String, Long> collect = programming.chars().mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().stream().filter(e->e.getValue()>1)
                .map(e -> e.getKey()) .forEach(System.out::println);

        //nonRepeatedFirstChar
        String nonRepeatedFirstChar = "swiss";

        Optional<Map.Entry<String, Long>> first = nonRepeatedFirstChar.chars().mapToObj(c -> String.valueOf((char) c)).
                collect(Collectors.groupingBy(Function.identity(),   () -> new LinkedHashMap<>(),    Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).findFirst();
        if(first.isPresent())
        System.out.println(first.get().getKey());

    }


}
