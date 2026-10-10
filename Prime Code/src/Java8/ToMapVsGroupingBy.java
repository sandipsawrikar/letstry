package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMapVsGroupingBy {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("tt",4500,"Finance"),
                new Employee("SkY",5500,"IT"),
                new Employee("ROHIT",7000,"HRA"),
                new Employee("Sachin1",3000,"Finance") ));


        Map<String, Employee> collect = employees.stream().collect(Collectors.toMap(employee -> employee.getName(), Function.identity()));
        System.out.println(collect);
        /*employees.stream().collect(Collectors.groupingBy(employee -> employee.getName()))
        System.out.println(collect1);*/


    }
}
