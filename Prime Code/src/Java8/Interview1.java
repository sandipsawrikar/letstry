package Java8;


import java.util.*;
import java.util.stream.Collectors;

public class Interview1 {
    static void main(String[] args) {

        List<String> list1 = List.of("Sandip", "Sachin", "Saurav", "Rahul", "Rohit", "Virat","Pant");
        Map<Character, List<String>> result = list1.stream().filter(e->e.startsWith("S") || e.startsWith("V") || e.startsWith("P") ).collect(Collectors.groupingBy(e -> e.charAt(0)));
        System.out.println(result);

        Map<Character, List<String>> result1= new HashMap<>();
        for (String s : list1) {
            if (!result1.containsKey(s.charAt(0))) {
                result1.put(s.charAt(0), new ArrayList<>());
            }
            result1.get(s.charAt(0)).add(s);
        }
        System.out.println(result1);

        List<String> names = Arrays.asList("Jake", "Sophia", "Lucas", "Mia","Tim","Tim", "Benjamin");
        Map<Integer, List<String>> groupedByLength = names.stream().distinct()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);


        int[] twoSum =twoSum();
        System.out.println(Arrays.toString(twoSum));
        maxProfit();

    }

    private static int[] twoSum() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;

        Map<Integer, Integer> numMap = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int remainingAmt = target - arr[i];

            if (numMap.containsKey(remainingAmt)) {
               return new int []{arr[i],remainingAmt};
            }
            numMap.put(arr[i], i);
        }

        return arr;
    }

    private static void maxProfit(){
        int[] arr = {10, 20, 30, 40, 50};

        int minPrice= arr[0];
        int profit=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]< minPrice)
                minPrice = arr[i];
            else if (arr[i]-minPrice >profit)
                profit = arr[i]-minPrice;
        }
        System.out.println(minPrice+" "+profit);
    }
}
