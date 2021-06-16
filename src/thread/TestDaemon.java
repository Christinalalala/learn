package thread;

public class TestDaemon {
    public static void main(String[] args) {
        Thread person = new Thread(new Y());
        person.start();
        Thread god = new Thread(new God());
        god.setDaemon(true);
        god.start();
    }
}

class Y implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("god with me");
        }
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("god bless you");
        }
    }
}