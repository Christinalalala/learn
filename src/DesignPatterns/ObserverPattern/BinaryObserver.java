package DesignPatterns.ObserverPattern;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary Search:" + Integer.toBinaryString(subject.getState()));
    }
}
