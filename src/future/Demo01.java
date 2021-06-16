package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步调用
 */
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值的异步回调 runAsync
//        CompletableFuture<Void> completedFuture = CompletableFuture.runAsync(()->{
////            try {
////                TimeUnit.SECONDS.sleep(1);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            System.out.println(Thread.currentThread().getName()+"runasync=>void");
////
////        });
////        System.out.println("111");
////        completedFuture.get();

        //有返回值的异步回调 supplyAsync
        //成功和失败的回调
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("completable");
            int i = 10 / 0;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);
            System.out.println("u=>" + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233; //可以获取到错误的返回结果
        }).get());
    }
}
