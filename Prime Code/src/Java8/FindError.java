package Java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindError {
    public static void main(String[] args) {
        List<Integer> l1= new CopyOnWriteArrayList<>() ;
        IntStream.range(1,1000).parallel().forEach(ele->l1.add(ele));
        Collections.sort(l1);
        System.out.println(l1.size());

        String str = "Java";

        String reversed = IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(c -> String.valueOf((char)(c)))
                .collect(Collectors.joining());

        System.out.println(reversed); // avaJ
    }
}
