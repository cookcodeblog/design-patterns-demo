[TOC]

# Singleton 单例模式



用法：

- 在创建对象的成本可忽略不计的情况下，选择静态加载方式，参见InitializedSingleton.java。

- 在并发不大的情况下，可选择同步锁方式，参见SynchronizedSingleton.java。

- 在并发量很大且同时要求懒加载时，选择双重检查加锁方式，参见DoubleCheckedLockingSingleton.java。

- 不推荐使用线程不安全的方式。

   

注意：

- 如果使用两个类加载器时，仍然可能会导致创建两个实例。除非指定用同一个类加载器。



