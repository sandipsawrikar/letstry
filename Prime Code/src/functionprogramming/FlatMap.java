package functionprogramming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        List<String> list = courses.stream().map(course -> course.getName()).toList();
        List<String> list1 = courses.stream().map(course -> course.getName()).toList();
        System.out.println(list);
        Function<String, Stream<List<String>>> stringStreamFunction =
                course -> list1.stream().map(course2 -> List.of(course, course2));
        List<List<String>> nestedList =
                list.stream().flatMap(stringStreamFunction).toList();
        System.out.println(nestedList);


        List<List<String>> nestedList1 =
                list.stream().flatMap(course -> list1.stream().
                        filter(course2 -> course2.length()==course.length()).
                        map(course2 -> List.of(course, course2))).
                        filter(x ->  ! x.get(0).equalsIgnoreCase(x.get(1))).toList();
       // System.out.println(nestedList1);


        List<List<String>> listList = list.stream().flatMap(x -> list1.stream().filter(z -> x.length() == z.length())
                .map(y -> List.of(x, y))).filter(x -> !x.get(0).equalsIgnoreCase(x.get(1))).toList();
        System.out.println(listList);

        list.stream().peek(System.out::println).filter(test -> test.length()>11).
                map(String::toUpperCase).peek(System.out::println).findAny();

        System.out.println(System.currentTimeMillis());
        var time= System.currentTimeMillis();
        long sum= LongStream.range(0, 10000000000L).sum();

       // System.out.println(System.currentTimeMillis()-time);
        long parellelSum= LongStream.range(0, 10000000000L).parallel().sum();

        System.out.println(System.currentTimeMillis()-time);

    }
    }

