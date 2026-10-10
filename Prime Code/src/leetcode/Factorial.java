package leetcode;

public class Factorial {
    public static void main(String[] args) {
        int fact= factorialMethod(4);
        System.out.print(fact);
    }

    private static int factorialMethod(int n) {
        if(n==0 || n==1) {
            return n;
        }
        return n * factorialMethod(n-1);
    }

}
