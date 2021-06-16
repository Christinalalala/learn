package thread;

public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "A").start();
        new Thread(station, "B").start();
        new Thread(station, "C").start();
    }
}

class BuyTicket implements Runnable {

    private int ticketNums = 10;

    boolean flag = true;

    @Override
    public synchronized void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {

        //模拟延迟

        Thread.sleep(1000);

        if (ticketNums <= 0) {
            flag = false;
            return;
        }

        //模拟延迟

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}