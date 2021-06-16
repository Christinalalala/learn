package bq;

import java.util.concurrent.*;

public class TestPool {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2, 5, 3,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
