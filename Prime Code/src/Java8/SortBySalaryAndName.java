package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortBySalaryAndName {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList( new Employee("Sandip",4000,"IT"),
                new Employee("Rupali",6000,"HR"),
                new Employee("Sachin",4500,"Finance"),
                new Employee("SkY",5500,"IT"),
                new Employee("ROHIT",7000,"HR"),
                new Employee("Sachin1",3000,"Finance") ));
        List<Employee> list= employees.stream().sorted(Comparator.comparing(Employee::getDepartment).
                thenComparing(Employee::getSalary).thenComparing(Employee::getName).reversed()).toList();

       /* List<Employee> list = employees.stream().sorted((emp1,emp2) -> {
            if(emp1.getSalary() > emp2.getSalary()) {
                return 1;
            }
            else if(emp1.getSalary() < emp2.getSalary()) {
                return -1;
            }
            else {
                return emp1.getName().compareTo(emp2.getName());
            }
        }).toList();*/
      /*  List<Employee> list = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());
*/


        System.out.println(list);
    }
}
