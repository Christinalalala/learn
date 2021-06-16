package thread;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在++++++++++++++++++");
        }
    }

    public static void main(String[] args) {
        TestRunnable t1 = new TestRunnable();
        new Thread(t1).start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在-----------------");
        }
    }
}
