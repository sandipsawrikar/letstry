package inheritance;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodingQuestions {


    static void main(String[] args) {

        reverseStringOldWay();
        reverseStringJava8();
        reverseStringOptimized();

        firstNonRepeatedCharacter();
        checkPalindrome();
        findDuplicateElements();
        findLargestElements();
        findSecondLargestElements();
        findCharFrequency();
        isAnagram();
        fibonacci();
        isPrime();
        findMissingNumber();


    }

    private static void findMissingNumber() {
        int[] nums = {0, 1, 3};
        int n = nums.length;
        System.out.println(n);
        int Tsum = (n * (n + 1)) / 2;
        int actualSum = Arrays.stream(nums).sum();
        System.out.println(Tsum - actualSum);
    }

    public static boolean isPrime() {
        int num = 11;
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (num % i == 0) {
                return false;
            }
        }
        System.out.println(" ");
        System.out.println( num +" is prime ");
        return true;
    }

    private static void
    fibonacci() {
        int n = 10;
        int a = 0;
        int b = 1;

        for (int i = 0; i <= n; i++) {

            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    private static void isAnagram() {
        String str1 = "rporgamming";
        String str2 = "programming";
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a, b)) {
            System.out.println("Anagram");
        }
    }

    private static void findCharFrequency() {
        String str = "programming";
        Map<Character, Long> characterLongMap = IntStream.range(0, str.length() - 1).mapToObj(i -> str.charAt(i)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(" Frequecy " + characterLongMap);
    }

    private static void findDuplicateElements() {

        int[] arr = {1, 2, 3, 4, 2, 5, 1};

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void findLargestElements() {

        int[] arr = {1, 2, 3, 4, 22, 5, 1};
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("max= " + max);
    }

    private static void findSecondLargestElements() {

        int[] arr = {1, 2, 3, 22, 22, 5, 11};
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {

                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println("secondMax= " + secondMax);
    }

    private static void checkPalindrome() {
        String str = "amadama";
        int left = 0;
        int right = str.length() - 1;
        boolean isPalindrome = true; // Assume it is a palindrome initially

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false; // Found a mismatch
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }

    private static void firstNonRepeatedCharacter() {
        String str = "swisssWWWw";
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap();



        for (int i = 0; i <= str.length() - 1; i++) {
            if (characterIntegerMap.containsKey(str.charAt(i))) {
                characterIntegerMap.put(str.charAt(i), characterIntegerMap.get(str.charAt(i)) + 1);
            } else {
                characterIntegerMap.put(str.charAt(i), 1);
            }
        }
        System.out.println(characterIntegerMap);
        Character characterIntegerEntry = characterIntegerMap.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get().getKey();
        System.out.println(characterIntegerEntry.toString());

        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }

    }

    private static void reverseStringJava8() {
        String str = "Java1";
        String reverse = IntStream.range(0, str.length()).mapToObj(i -> String.valueOf(str.charAt(str.length() - i - 1))).collect(Collectors.joining());
        System.out.println(reverse);
    }

    private static void reverseStringOldWay() {
        String str = "Java1";
        char[] charArr = str.toCharArray();
        int left = 0;
        int right = charArr.length - 1;

        while (left < right) {
            char temp = charArr[right];
            charArr[right] = charArr[left];
            charArr[left] = temp;
            left++;
            right--;
        }
        System.out.println(charArr);
    }
    private static String reverseStringOptimized() {
        String str = "Java1";

        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            char temp = sb.charAt(right);
            sb.setCharAt(right, sb.charAt(left));
            sb.setCharAt(left, temp);
            left++;
            right--;
        }

        return sb.toString();
    }
}
