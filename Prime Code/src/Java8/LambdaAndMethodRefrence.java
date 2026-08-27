package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaAndMethodRefrence {
    
    public static void main(String[] args) {


Display display= Display::show;
Employee employee= new Employee("Rohit",6000,"HR");
        Display show = Display::show;
   //     display.display(employee);
        Display.show(employee);

     //   show.show(employee);




    }



}
