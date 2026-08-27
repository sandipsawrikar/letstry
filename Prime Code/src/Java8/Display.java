package Java8;

@FunctionalInterface
public interface Display {
    void display(Employee employee);
    static void show(Employee employee){
    //employee.setDepartment("test");
        System.out.println(employee);
    }
    //void display1(Employee employee);

}
