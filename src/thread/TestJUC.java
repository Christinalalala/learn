package thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(300);
        System.out.println(list.size());
    }
}
