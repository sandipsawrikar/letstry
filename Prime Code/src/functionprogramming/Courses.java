package functionprogramming;

import java.util.List;

public class Courses {
    public static void main(String[] args){

        List<String> courses= List.of("Spring","Java8", "REST","SOAP","Docker");
        courses.stream().forEach(System.out::println);

        courses.stream().filter(str -> str.contains("Spring")).forEach(System.out::println);
    }

}
