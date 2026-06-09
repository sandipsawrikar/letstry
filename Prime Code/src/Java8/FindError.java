package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindError {
    public static void main(String[] args) {
        List<Integer> l1= new ArrayList<>() ;
        IntStream.range(1,1000).parallel().forEach(ele->l1.add(ele));
        System.out.println(l1);
    }
}
