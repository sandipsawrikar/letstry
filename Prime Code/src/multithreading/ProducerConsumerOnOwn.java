package multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerOnOwn {
    static void main(String[] args) {

        SharedResource sharedResource= new SharedResource();
        Thread t1 = new Thread(){
            int i =1;
            @Override
            public void run() {
                while (true) {
                    sharedResource.produce(i);
                    i++;
                    try {
                        Thread.sleep(280);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        };
        Thread t2 = new Thread(){
          //  int i =sharedResource.arrayBlockingQueue.size();
            @Override
            public void run() {
               // while(i>0) {
                while (true) {
                    sharedResource.consume();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };

        t1.start();
        t2.start();
    }
}

class SharedResource{

    ArrayBlockingQueue<Integer> arrayBlockingQueue= new ArrayBlockingQueue(4);

    public void produce(Integer i){
        arrayBlockingQueue.add(i);
        System.out.println("Produced"+i);
    }

    public void consume(){
        Integer i= arrayBlockingQueue.poll();
        System.out.println("Consumed"+i);
    }


}
