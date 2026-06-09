package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllEmployeeNames {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sachin",4500,"Finance"),
                new Employee("SkY",5500,"IT"),
                new Employee("ROHIT",7000,"HRA"),
                new Employee("Sachin1",3000,"Finance") ));
        employees.parallelStream().map(Employee::getName).forEach(System.out::println);
        Integer reduce = employees.parallelStream().map(Employee::getSalary).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);


    }
}
