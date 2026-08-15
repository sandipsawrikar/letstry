package functionprogramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FPCustom {

    private static Comparator<Course> increaseingByNoOfstudents;

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore)))));
        System.out.println(courses.stream().parallel().collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList()))));

        System.out.println(courses.stream().anyMatch( s-> s.getNoOfStudents() >20000));
        System.out.println(courses.stream().allMatch( s-> s.getNoOfStudents() >20000));
        System.out.println(courses.stream().noneMatch( s-> s.getNoOfStudents() >20000));

        Comparator<Course> reversedByNoOfstudents = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        List<Course> sortedByNoOfstudentsReversed = courses.stream().sorted(reversedByNoOfstudents).toList();
        System.out.println(sortedByNoOfstudentsReversed);

        Comparator<Course> increaseingByNoOfstudents = Comparator.comparingInt(Course::getNoOfStudents);
        List<Course> sortedByNoOfstudents = courses.stream().sorted(increaseingByNoOfstudents).toList();
        System.out.println(sortedByNoOfstudents);

        Comparator<Course> reversedByNoOfStudentsThenScore = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
        List<Course> sortedByReversedByNoOfStudentsThenScore= courses.stream().sorted(reversedByNoOfStudentsThenScore).toList();
        System.out.println(sortedByReversedByNoOfStudentsThenScore);

        List<Course> sortedByReversedByNoOfStudentsThenScoreTop5= courses.stream().sorted(reversedByNoOfStudentsThenScore).limit(5).toList();
        System.out.println(sortedByReversedByNoOfStudentsThenScoreTop5);

        System.out.println( courses.stream().sorted(Comparator.comparingInt(Course::getReviewScore)).takeWhile(course -> course.getReviewScore() ==91 ).toList());
        System.out.println( courses.stream().sorted(Comparator.comparingInt(Course::getReviewScore)).dropWhile(course -> course.getReviewScore() ==91 ).toList());

        System.out.println( courses.stream().max(Comparator.comparingInt(Course::getReviewScore)));
        System.out.println( courses.stream().min(Comparator.comparingInt(Course::getReviewScore)).orElse( new Course("Kubernetes", "Cloud", 91, 20000)));

        Predicate<Course> startsWithA = course -> course.getName().startsWith("A");
        System.out.println( courses.stream().filter(startsWithA).max(Comparator.comparingInt(Course::getReviewScore)));
        System.out.println( courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));

        System.out.println( courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparingInt(Course::getReviewScore)))));
        System.out.println( courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList()))));

        OptionalInt min = OptionalInt.of(Arrays.stream(new int[]{1, 4, 5, 7, 4, 6}).min().orElse(2));
        System.out.println(min.getAsInt());

        Optional<Integer> min1 = Stream.of(1, 4, 5, 7, 4, 6).min(Comparator.comparingInt(value -> value));
        System.out.println(min1.get());

        System.out.println(IntStream.range(1,10).reduce(0,Integer::sum));
        System.out.println(IntStream.rangeClosed(1,10).reduce(0,Integer::sum));

        System.out.println(IntStream.iterate(1, a -> a+2).limit(10).boxed().toList());
        System.out.println(IntStream.rangeClosed(1,10).reduce(1,(x,y)-> x*y));

        List<String> list = courses.stream().map(Course::getName).toList();
        System.out.println(list);
        System.out.println(list.stream().collect(Collectors.joining(",")));

    }//[FullStack:14000:91, Kubernetes:20000:91, AWS:21000:92, Docker:20000:92, Spring Boot:18000:95, Microservices:25000:96, API:22000:97, Spring:20000:98, Azure:21000:99]


}
