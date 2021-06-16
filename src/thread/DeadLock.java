package thread;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new ThreadDemo(lockA, lockB), "T1").start();
        new Thread(new ThreadDemo(lockB, lockA), "T1").start();

    }
}

class ThreadDemo implements Runnable {

    private String A;

    private String B;

    public ThreadDemo(String a, String b) {
        A = a;
        B = b;
    }

    @Override
    public void run() {
        synchronized (A) {
            System.out.println(Thread.currentThread().getName() + " get " + A + ",next" + B);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + " get " + B + ",done");
            }
        }
    }
}
