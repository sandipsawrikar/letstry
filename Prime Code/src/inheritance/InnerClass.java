package inheritance;

import java.util.*;

public class InnerClass extends  Object {

   static void test(int a) {
        System.out.println(a);
    }
    static <T extends Number> T test22( T t){

       return t;
    }
    static void  test221( List <? super Integer> t){

    }
    static void test(int ... numbers) {
        System.out.println(Arrays.toString(numbers));
    }
    class A {
        int inner = 1;
    };

    static class B {
        int staticInner = 2;
    };

    public static void main(String[] args) {

       /* A a = new InnerClass().new A();
        System.out.println(a.inner);
        B b= new InnerClass. B();
        System.out.println(b.staticInner);

        InnerClass innerClass = new InnerClass(){
            void test(){
                System.out.println("anonymous class");
            }
        };
        innerClass.test();;*/

       TreeSet<Integer> integers= new TreeSet<>();
       integers.add(24);
       integers.add(20);
       integers.add(35);
        System.out.println(integers.floor(26));
        System.out.println(integers.lower(26));
        System.out.println(integers.higher(26));
        System.out.println(integers.ceiling(26));



    }




}
