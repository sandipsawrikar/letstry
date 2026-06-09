package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class Highest2Salarys {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sachin",5500,"Finance"),
                new Employee("SKY",5500,"IT"),
                new Employee("ROHIT",7000,"HR"),
                new Employee("Kishan",4500,"Finance") ));

        List<Employee> list = employees.stream().sorted(Comparator.comparingInt(emp -> -1 * emp.getSalary())).limit(2).
                collect(Collectors.toList());
        System.out.println(list);
    }
}
