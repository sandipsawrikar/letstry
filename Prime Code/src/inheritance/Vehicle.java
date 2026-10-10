package inheritance;

public class Vehicle implements  Comparable  {
    static void main(String[] args) {
        System.out.println("vehicle");

        Car car =() ->{
            System.out.println("car");
        };
        car.test();
        Car car1 = new Car() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };
        car1.test();;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
