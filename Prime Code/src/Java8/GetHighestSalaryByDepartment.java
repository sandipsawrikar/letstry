package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class GetHighestSalaryByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sachin",4500,"Finance"),
                new Employee("SkY",5500,"IT"),
                new Employee("ROHIT",7000,"HRA"),
                new Employee("Sachin1",3000,"Finance") ));

        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println(collect);

    }
}
