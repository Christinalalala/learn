package thread;

public class UnsafeBank extends Thread {
    public static void main(String[] args) {
        Account account = new Account(100, "基金");
        Drawing you = new Drawing(account, 50, "你");
        Drawing gf = new Drawing(account, 100, "女票");

        you.start();
        gf.start();
    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int cash;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，交易失败");
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            cash += cash + drawingMoney;
            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(this.getName() + "手里的钱" + cash);
        }

    }
}