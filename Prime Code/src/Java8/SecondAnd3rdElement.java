package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondAnd3rdElement {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5,3,2,3,2,5,4);
        List<Integer> list1 = list.stream().skip(1).limit(2).toList();
        System.out.println(list1);

    }
}
