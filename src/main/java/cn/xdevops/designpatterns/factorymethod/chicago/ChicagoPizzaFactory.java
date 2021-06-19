package cn.xdevops.designpatterns.factorymethod.chicago;

import cn.xdevops.designpatterns.factorymethod.Pizza;
import cn.xdevops.designpatterns.factorymethod.SimplePizzaFactory;

public class ChicagoPizzaFactory extends SimplePizzaFactory {
    // override superclass behavior
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // support ordering more pizza types
        // add city style
        if ("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ChicagoStyleClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
