package Java8;

import java.util.*;

public class SalaryGreaterThan5000 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sachin",5500,"Finance"),
                new Employee("SKY",5000,"IT"),
                new Employee("ROHIT",7000,"HR"),
                new Employee("Kishan",4500,"Finance") ));
        Optional<Employee> first = employees.stream().filter(emp -> emp.getSalary() > 5000).findFirst();

        first.ifPresent(System.out::println);


    }
}
