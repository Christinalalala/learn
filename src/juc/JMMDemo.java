package juc;

import java.util.concurrent.TimeUnit;

public class JMMDemo {

    private volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (i == 0) {

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        i = 1;
        System.out.println(i);
    }
}
