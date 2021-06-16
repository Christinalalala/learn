package thread;


public class TestPC {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}

class Producer extends Thread {
    Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.push(new Chicken(i));
            System.out.println("生产了第" + (i + 1) + "只鸡");
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第" + (buffer.eat().id + 1) + "只鸡");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class Buffer {

    //大小
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    //生产者放入产品

    public synchronized void push(Chicken chicken) {
        //如果满了，就等待消费者消费，生产者等待
        if (count == chickens.length) {
            //通知消费者消费，生产者等待

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满就要丢入产品
        chickens[count] = chicken;
        count++;

        //可以通知消费者消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken eat() {
        if (count == 0) {
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        //吃完了,通知生产者生产
        return chicken;
    }
}