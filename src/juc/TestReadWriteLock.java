package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();
        for (int i = 0; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void put(String key, Object value) {
        try {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) {

        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "读取" + key);

            Object o = map.get(key);

            System.out.println(Thread.currentThread().getName() + "读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }


    }
}