package leetcode;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharFromString {
    public static void main(String[] args) {
        String str = "testetttsssxy";

        for(char c: str.toCharArray()){
            if(str.indexOf(c)==str.lastIndexOf(c)) {
                System.out.println(c);
               break;
            }
        }

        Character c1 = str.chars().mapToObj(c -> (char) c).
                       collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet().stream().
                       filter(c -> c.getValue() == 1).
                       map(key -> key.getKey()).skip(1).findFirst().orElse(null);

        System.out.print(c1);
    }
}
