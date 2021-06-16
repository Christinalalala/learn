package DesignPatterns.Singleton;

public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}
