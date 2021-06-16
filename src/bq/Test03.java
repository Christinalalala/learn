package bq;

import java.util.concurrent.ArrayBlockingQueue;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }
}
