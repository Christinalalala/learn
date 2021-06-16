package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();
        int y = 1;
        for (System.out.println("a"); y < 3; System.out.println("c")) {
            System.out.println("d");
            y++;
        }

    }


    public static void test1() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 1L; i <= 1_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum用时：" + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 10__0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("sum用时：" + (end - start));
    }

    public static void test3() {
        Long sum = 0L;
        long start = System.currentTimeMillis();
        //Stream并行流
        //
        long reduce = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        System.out.println(reduce);
        long end = System.currentTimeMillis();
        System.out.println("sum用时：" + (end - start));
    }
}
