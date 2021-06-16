package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();//结果被缓存 ， 效率高
        String result = futureTask.get();//这个get可能会造成阻塞，放到最后或者使用异步通信
        System.out.println(result);

    }
}

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "call";
    }
}
