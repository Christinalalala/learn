package juc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestCopyOnWriteSet {

    public static void main(String[] args) {
        //Set<Object> set = new HashSet<>();
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        //Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }).start();
        }
    }
}
