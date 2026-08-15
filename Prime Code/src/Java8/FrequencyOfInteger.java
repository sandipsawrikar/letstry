package Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfInteger
{
    public static void main(String[] args) {

        Integer [] arr = {1, 2, 2, 4,4, 6, 5, 10, 9, 10};
        List<Integer> numbers = Arrays.asList(arr);

        Map<Integer, Long> collect = numbers.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));

        HashMap<Integer, Integer> count= new HashMap<>();

        for(int i=0;i<arr.length;i++){

            if(count.containsKey(arr[i])){
                Integer counter =    count.get(arr[i]) + 1;
                count.put(arr[i], counter);
            }
            else {
                count.put(arr[i], 1);
            }
        }
        System.out.println(count);
        System.out.println(numbers);
        System.out.println(collect);
    }
}
