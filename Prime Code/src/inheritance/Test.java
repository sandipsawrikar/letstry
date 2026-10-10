package inheritance;

import java.util.Arrays;

public class Test extends  Vehicle implements Runnable,AutoCloseable {
    static String [] t;
    static void main() {
        Vehicle.main(t);
    }

    @Override
    public void run() {

    }

    @Override
    public void close() throws Exception {

    }
}
