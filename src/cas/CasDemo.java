package cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        //如果我期望的值拿到了就更新 否则就不更新
        atomicInteger.getAndIncrement();
        atomicInteger.compareAndSet(2020, 2021);
        System.out.println(atomicInteger.get());
    }
}
