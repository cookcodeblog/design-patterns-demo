package cn.xdevops.designpatterns.factorymethod.california;

import cn.xdevops.designpatterns.factorymethod.Pizza;
import cn.xdevops.designpatterns.factorymethod.SimplePizzaFactory;

public class CaliforniaPizzaFactory extends SimplePizzaFactory {
    // override superclass behavior
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // support ordering more pizza types
        // add city style
        if ("cheese".equals(type)) {
            pizza = new CaliforniaStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new CaliforniaStylePepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new CaliforniaStyleClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new CaliforniaStyleVeggiePizza();
        }
        return pizza;
    }
}
