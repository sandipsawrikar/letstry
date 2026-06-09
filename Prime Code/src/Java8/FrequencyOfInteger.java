package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfInteger
{
    public static void main(String[] args) {

        Integer [] arr = {1, 2, 2, 4,4, 6, 5, 10, 9, 10};
        List<Integer> numbers = Arrays.asList(arr);

        Map<Integer, Long> collect = numbers.stream().
                collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println(numbers);
        System.out.println(collect);
    }
}
