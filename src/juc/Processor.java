package juc;

public class Processor {

    public static void main(String[] args) {
        //获取处理器核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
