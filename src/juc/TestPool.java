package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {

    //只要代码敲的够快  难过的事就追不上我
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService scheduledExecutorService = Executors.newSingleThreadExecutor();

        try {
            for (int i = 0; i < 100; i++) {
                cachedThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cachedThreadPool.shutdown();
        }
    }
}
