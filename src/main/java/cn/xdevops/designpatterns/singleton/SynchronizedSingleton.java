package cn.xdevops.designpatterns.singleton;

public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {
    }

    // add synchronized to make it as thread-safe method
    // but may cause performance issue!
    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
