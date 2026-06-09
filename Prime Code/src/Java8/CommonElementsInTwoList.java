package Java8;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInTwoList
{
    public static void main(String[] args) {
        List<Integer> l1= Arrays.asList(1,2,3,4);
        List<Integer> l2= Arrays.asList(3,4,5,6);
        List<Integer> commonList = l2.stream().filter(l1::contains).toList();
        System.out.println(commonList);
        Set<Integer> s1= new HashSet<>(l1);
        List<Integer> list = l2.stream().filter(ele -> !s1.contains(ele)).toList();
        System.out.println(list);
    }
}
