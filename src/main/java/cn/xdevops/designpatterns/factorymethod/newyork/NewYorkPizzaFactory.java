package cn.xdevops.designpatterns.factorymethod.newyork;

import cn.xdevops.designpatterns.factorymethod.Pizza;
import cn.xdevops.designpatterns.factorymethod.SimplePizzaFactory;

public class NewYorkPizzaFactory extends SimplePizzaFactory {

    // override superclass behavior
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // support ordering more pizza types
        // add city style
        if ("cheese".equals(type)) {
            pizza = new NewYorkStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new NewYorkStylePepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new NewYorkStyleClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new NewYorkStyleVeggiePizza();
        }
        return pizza;
    }
}
