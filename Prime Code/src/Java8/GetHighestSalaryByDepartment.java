package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetHighestSalaryByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sandip",4500,"Finance"),
                new Employee("SkY",5500,"IT"),
                new Employee("ROHIT",7000,"HRA"),
                new Employee("Sachin1",3000,"Finance") ));

        Map<String, List<String>> collect1 = employees.stream().map(Employee::getName)
                .collect(Collectors.groupingBy(emp -> emp));
        System.out.println(collect1);

        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println(collect);

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));


        Map.Entry<String, Double> result =
                avgSalaryByDept.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElse(null);

        System.out.println(result);

        List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).toList();


        System.out.println(list);

        String str = "swiss";

        Character result2 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result2);
    }
}
