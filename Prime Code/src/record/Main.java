package record;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("dog","X",100);
        Animals animal1 = new Animals("dog","X",100);
        System.out.println(animal1);

        List<String> myRoles = new ArrayList<>();
        myRoles.add("Viewer");

        User user = new User("Alice", myRoles);

        // You CANNOT reassign the list reference:
        // user.roles() = new ArrayList<>(); // Compile Error!
        System.out.println(user.roles());
        // But you CAN modify the contents of the list:
        user.roles().add("Admin");
        System.out.println(user.roles());
    }
}
