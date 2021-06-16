package forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 1.forkjoinpoll 用这个来执行
 * 2.forkjoinpoll.execute(ForkJoinTask task)
 * 3.计算类一定继承ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else { //forkjoin
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();//拆分任务
            return task1.join() + task2.join();
        }
    }

}
