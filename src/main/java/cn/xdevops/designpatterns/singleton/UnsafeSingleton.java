package cn.xdevops.designpatterns.singleton;

public class UnsafeSingleton {
    // a static filed containing its only instance
    private static UnsafeSingleton instance;

    // a private constructor
    private UnsafeSingleton() {
    }

    // a static factory method for obtaining the instance
    // thread-unsafe!
    public static UnsafeSingleton getInstance() {
        if (instance == null) {
            // lazy initialization
            instance = new UnsafeSingleton();
        }
        return instance;
    }
}
