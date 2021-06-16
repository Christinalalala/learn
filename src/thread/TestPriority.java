package thread;

public class TestPriority {
    public static void main(String[] args) {
        //主线程默认值优先级为5
        System.out.println(Thread.currentThread().getPriority());
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--" + Thread.currentThread().getPriority());
    }
}
