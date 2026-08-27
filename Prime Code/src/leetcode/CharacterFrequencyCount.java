package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyCount {
    public static void main(String[] args) {
        String str = "testetttsss";
        Map<Character, Integer> stringIntegerMap = new HashMap<>();

        for(Character s : str.toCharArray()) {
            stringIntegerMap.put(s, stringIntegerMap.getOrDefault(s, 0) + 1);
        }
        stringIntegerMap.entrySet().stream().forEach(System.out::println);



        Map<Character, Long> frequencyMap = str.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(frequencyMap);

    }
}
