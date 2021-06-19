package cn.xdevops.designpatterns.factorymethod;

public class StaticPizzaFactory {

    // static create pizza method
    public static Pizza createPizza(String type) {
        Pizza pizza = null;
        // support ordering more pizza types
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
