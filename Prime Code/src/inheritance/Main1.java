package inheritance;

 class SingleTone {
    private int age;
    private static SingleTone instance = new SingleTone();

    private SingleTone(){

    }

    public static synchronized SingleTone getInstance() {

            if (instance == null)
                instance = new SingleTone();
            return instance;

    }


}
public class Main1{
    static void main(String[] args) {
        SingleTone singleTone  = SingleTone.getInstance();
        SingleTone singleTone1  =  SingleTone.getInstance();

        System.out.println(singleTone.hashCode());
        System.out.println(singleTone1.hashCode());
    }
}
