package inheritance;

@FunctionalInterface
public interface Car {
    default void drive(){
        System.out.print("Car");
    }
    void test();
}
