package Java8;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<Employee> student = Optional.ofNullable(getStudentWithName("hamza"));
        if (student.isPresent()) {
            Optional<String> name = Optional.ofNullable(student.get().getName());
            if(name.isPresent()) {
                System.out.println(name.get().length());
            }
        } else {
            System.out.println("Student  is not present");
        }
    }

    public  static Employee  getStudentWithName(String name ){
        // lets suppose that our database contain only 2 students ahmed and hamza .
        if (name.equals("hamza") || name.equals("ahmed")) {
            return new Employee(null , 220000 , "Morocco");
        } else {
            return null ;
        }
    }
}
