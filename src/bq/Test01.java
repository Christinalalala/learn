package bq;

import java.util.concurrent.ArrayBlockingQueue;

public class Test01 {
    public static void main(String[] args) {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //  System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.element());
        //System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.peek());
    }
}
