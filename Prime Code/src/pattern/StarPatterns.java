package pattern;

public class StarPatterns {
    static void main(String[] args) {
       // pattern1();
        //pattern2();
       // pattern3();
        // pattern4();
        //pattern5();
       sort();
    }
    private static void sort() {

        int[] numbers = {10, 20, 30, 40, 50,9};
        int min= Integer.MAX_VALUE;

        for (int i = 0; i <=numbers.length-1; i++) {
                if(numbers[i]<min)
                    min=numbers[i];
        }
            System.out.println(min);

    }


    private static void pattern5() {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern4() {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern1() {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern2() {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern3() {
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("j"+" ");
            }
            System.out.println();
        }
    }
}
