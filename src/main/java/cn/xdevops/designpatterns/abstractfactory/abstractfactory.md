[TOC]

# Abstract Factory 抽象工厂模式



## 定义

抽象工厂模式提供一个接口，用于创建相关或依赖的对象的家族，而不需要明确制定具体类。



## 比较工厂方法和抽象工厂



工厂方法：

- 可以把客户代码从需要实例化的具体类中解耦。
- 或者如果你目前还不知道将来需要实例化哪些具体类时。
- 生产一个产品。



抽象工厂：

- 需要创建产品家族和想让制造的相关产品集合起来时。
- 负责在抽象工厂中创建的方法，通常是以“工厂方法”实现的。
- 生产一个产品家族/系列。



