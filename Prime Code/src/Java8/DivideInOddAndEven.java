package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivideInOddAndEven {
        public static void main(String[] args) {
            Integer [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            List<Integer> numbers = Arrays.asList(arr);
            Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(el -> el % 2 == 0));

            System.out.println(collect);

        }
}
