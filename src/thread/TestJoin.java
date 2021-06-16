package thread;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程vip来了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                thread.join();
            }
            System.out.println("main");
        }
    }
}
