package inheritance;

public interface Scooter {

    default void drive(){
        System.out.print("Car");
    }
}
