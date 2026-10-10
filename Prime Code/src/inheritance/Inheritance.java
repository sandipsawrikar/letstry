package inheritance;

public class Inheritance {
    static void main(String[] args) {
        parent p = new child();
        p.test();
    }
}

interface parent{
    void test();
}
class child implements parent{

    @Override
    public void test() {
        System.out.println("***parent");
    }
}