package cn.xdevops.designpatterns.singleton;

public class DoubleCheckedLockingSingleton {
    private volatile static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    // check instance again before create instance in synchronized lock
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        // if instance is not null, return the instance directly
        // avoid entering synchronized lock
        return instance;
    }
}
