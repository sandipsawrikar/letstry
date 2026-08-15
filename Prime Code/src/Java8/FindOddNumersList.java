package Java8;

import java.util.*;

public class FindOddNumersList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("123","23","22","25"));
        List<String> numberList=  list.stream().filter(Objects::nonNull).filter(n -> !n.startsWith("1")).filter(n -> Integer.parseInt(n) % 2 !=0 ).toList();
        System.out.println(numberList);
        System.out.println(list);
    }
}
