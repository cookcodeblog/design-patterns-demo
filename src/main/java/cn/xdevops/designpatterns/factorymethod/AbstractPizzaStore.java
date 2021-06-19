package cn.xdevops.designpatterns.factorymethod;

public abstract class AbstractPizzaStore {

    Pizza orderPizza(String type) {
        // customize pizza style in subclass
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
