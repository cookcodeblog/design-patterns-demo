package cn.xdevops.designpatterns.singleton;

public class InitializedSingleton {
    // static initialization when load this class
    // may slow down application starting!
    private static InitializedSingleton instance = new InitializedSingleton();

    private InitializedSingleton() {
    }

    public static InitializedSingleton getInstance() {
        return instance;
    }
}
