package thread;

//创建线程方式1
//线程开始不一定立即执行，由cpu调度
//start方法会创建一个新线程然后执行run方法，直接run的话，并不会创建新线程
public class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("在看代码------------------");
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("在写作业+++++++++++++++++++++");
        }
    }
}
