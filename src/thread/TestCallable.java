package thread;

import java.util.concurrent.*;

public class TestCallable implements Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        TestCallable callable = new TestCallable();
        Future<Integer> result = executorService.submit(callable);
        System.out.println(result.get());
        executorService.shutdown();
        ///////////////////////////////////////////////////////
        FutureTask<Integer> futureTask = new FutureTask<>(new TestCallable());
        new Thread(futureTask).start();
        System.out.println("futureTask" + futureTask.get());
    }

    @Override
    public Integer call() throws Exception {
        return 100;
    }
}
