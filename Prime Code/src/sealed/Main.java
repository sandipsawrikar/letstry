package sealed;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car(); // ✅ Allowed
        Vehicle v2 = new Bike(); // ✅ Allowed
        Vehicle v3 = new ElectricBike(); // ✅ Allowed (due to non-sealed)
    }
}