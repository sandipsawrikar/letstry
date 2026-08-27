package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateCharFromString {
    public static void main(String[] args) {
        String str = "testererxyz";
        StringBuilder  stringBuilder=  new StringBuilder();
        Set set= new HashSet();
        for (Character c : str.toCharArray()) {
            if (set.add(c)){
                stringBuilder.append(c);
            }
        }

        String result = str.chars().distinct().mapToObj(Character::toString).collect(Collectors.joining());
        System.out.println(result);
        System.out.println(stringBuilder);
        String result1 = str.chars().distinct().mapToObj(c-> Character.toString((char) c)).collect(Collectors.joining());
        System.out.println(result1);

        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");

        List<String> result2 = names.stream().peek(x-> System.out.println(x)).toList();

        System.out.println("\nFinal Result List: " + result2);
    }
}
