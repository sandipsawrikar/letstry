package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommaSpeartedNames {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sachin",4500,"Finance"),
                new Employee("SkY",5500,"IT"),
                new Employee("ROHIT",7000,"HRA"),
                new Employee("Sachin1",3000,"Finance") ));

        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(employees.stream().map(Employee::getName).collect(Collectors.joining("_")));
        System.out.println(collect);

     Integer secondHighest = employees.stream().map(emp -> emp.getSalary()).distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst().orElse(null);
        System.out.println(secondHighest);

    }
}
