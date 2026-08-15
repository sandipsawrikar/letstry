package functionprogramming;

import java.util.List;
import java.util.function.*;

public class AddListFunctional {
    public static void main(String[] args){

        List<Integer> courses= List.of(2,3,4,5);
        int sum = courses.stream().reduce(0, Integer::sum);
        //System.out.println(sum);

        int square = courses.stream().map(x-> x*x).reduce(0, Integer::sum);
       // System.out.println(courses);

        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return  x%2 == 0;
            }
        };
        Function<Integer, Integer> integerIntegerFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return  x * x * x;
            }
        };
        Consumer<Integer> println = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        courses.stream().filter(x->x % 2 == 0).map(x -> x * x * x).forEach(System.out::println);
        BinaryOperator<Integer> multiplyBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer*integer2;
            }
        };
        Integer reduce = courses.stream().reduce(1, multiplyBinaryOperator);
        System.out.println(reduce);
        
        courses.stream().filter(x -> x%2 == 0).toList();
        filtereven(courses,x -> x%3 == 0);
        filterOdd(courses,x -> x%2 != 0,integerIntegerFunction);

        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {

            @Override
            public Integer apply(Integer integer) {
                return 25*25*25;
            }
        };

        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return 25*25;
            }
        };
        System.out.println(supplier.get());

    }

    private static void filterOdd(List<Integer> courses, Predicate<Integer> evenPredicate, Function<Integer, Integer> integerIntegerFunction) {
        courses.stream().filter(evenPredicate).map(integerIntegerFunction).forEach(System.out::println);
    }

    private static void filtereven(List<Integer> courses, Predicate<Integer> evenPredicate) {
        courses.stream().filter(evenPredicate).forEach(System.out::println);
    }



}
