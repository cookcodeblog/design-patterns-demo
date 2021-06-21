[TOC]

# Iterator 迭代器模式



## 定义

迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。



## 结构

- Iterator接口
  - 具体的Iterator类实现该接口
- Aggregate 聚合接口
  - 具体的Aggregate类实现该接口
  - 具体的Aggregate类来创建相应的Iterator类的实例
- Client客户端
  - 客户端只需要关心聚合接口和迭代器接口。