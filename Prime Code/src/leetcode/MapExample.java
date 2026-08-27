package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    private String name;
    private int salary;

    public Employee(String name ,int salary) {
        this.name = name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}

public class MapExample {
    public static void main(String[] args) {
        List<Department> departments = Arrays.asList(
                new Department("HR", Arrays.asList(new Employee("Emma",1000), new Employee("Liam",2000))),
                new Department("IT", Arrays.asList(new Employee("Ava",3000), new Employee("Noah",2000))),
                new Department("Finance", Arrays.asList(new Employee("Olivia",1000), new Employee("Mason",5000)))
        );


        // Approach 1: Get the Employee object with the Max Salary per Department
        Map<String, Optional<Employee>> maxSalaryEmployeeMap = departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        dept -> dept.getEmployees().stream()
                                .max(Comparator.comparingDouble(Employee::getSalary))
                ));

        System.out.println("Max Salary Employee by Dept: " + maxSalaryEmployeeMap);


        // Approach 2: Get only the Max Salary numeric value per Department
        Map<String, Double> maxSalaryMap = departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        dept -> dept.getEmployees().stream()
                                .mapToDouble(Employee::getSalary)
                                .max()
                                .orElse(0.0) // Handles empty employee lists gracefully
                ));

        System.out.println("Max Numeric Salary by Dept: " + maxSalaryMap);


        Map<String, Integer> collect = departments.stream().collect(Collectors.
                toMap(Department::getName, department -> department.getEmployees().stream().mapToInt(Employee::getSalary).max().orElse(0)));
        System.out.println("Max Numeric Salary by Dept ---: " + collect);

        List<String> employeeList = departments.stream()
                .flatMap(department -> department.getEmployees().stream()) // Flatten the nested lists
                .map(Employee::getName)
                .toList();

        System.out.println(employeeList);


    }
}
