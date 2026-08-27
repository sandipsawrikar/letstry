package leetcode;

public class RotateString {

    // Left rotate a string by d positions
    public static String leftRotate(String str, int d) {
        if (str == null || str.isEmpty()) return str;

        int n = str.length();
        d = d % n; // Handle rotation counts larger than string length
return str.substring(2)+str.substring(0,d);

    }

    // Right rotate a string by d positions
    public static String rightRotate(String str, int d) {
        if (str == null || str.isEmpty()) return str;

        int n = str.length();
        d = d % n;

     return str.substring(n-d, n)+str.substring(0,n-d);
    }

    public static void main(String[] args) {
        String str = "Sandip";
        int d = 2;

        System.out.println("Original: " + str);
        System.out.println("Left Rotate by " + d + ": " + leftRotate(str, d));   // Outputs: cdefgab
        System.out.println("Right Rotate by " + d + ": " + rightRotate(str, d)); // Outputs: fgabcde
    }
}