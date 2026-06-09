package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateRemoval
{

    public static  void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(5,3,2,3,2,5,4));
        List<Integer> sorted = list.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted);

    }
}
