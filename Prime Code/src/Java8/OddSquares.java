package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddSquares
{

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        List<Integer> list1 = list.stream().filter(elem -> elem % 2 != 0).map(elem -> elem * elem).toList();

        System.out.println(list1);
    }
}
