package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingleListFromListOfList {
    public static void main(String[] args) {
        List<List<Integer>> l1= Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(5,6,7),
                Arrays.asList(7,6,8,9),Arrays.asList(5,6,7,10));
        List<Integer> collect = l1.stream().flatMap(innerList -> innerList.stream()).distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
