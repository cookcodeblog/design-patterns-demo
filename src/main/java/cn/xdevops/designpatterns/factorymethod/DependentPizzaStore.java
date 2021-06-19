package cn.xdevops.designpatterns.factorymethod;

import cn.xdevops.designpatterns.factorymethod.california.CaliforniaStyleCheesePizza;
import cn.xdevops.designpatterns.factorymethod.california.CaliforniaStyleClamPizza;
import cn.xdevops.designpatterns.factorymethod.california.CaliforniaStylePepperoniPizza;
import cn.xdevops.designpatterns.factorymethod.california.CaliforniaStyleVeggiePizza;
import cn.xdevops.designpatterns.factorymethod.chicago.ChicagoStyleCheesePizza;
import cn.xdevops.designpatterns.factorymethod.chicago.ChicagoStyleClamPizza;
import cn.xdevops.designpatterns.factorymethod.chicago.ChicagoStylePepperoniPizza;
import cn.xdevops.designpatterns.factorymethod.chicago.ChicagoStyleVeggiePizza;
import cn.xdevops.designpatterns.factorymethod.newyork.NewYorkStyleCheesePizza;
import cn.xdevops.designpatterns.factorymethod.newyork.NewYorkStyleClamPizza;
import cn.xdevops.designpatterns.factorymethod.newyork.NewYorkStylePepperoniPizza;
import cn.xdevops.designpatterns.factorymethod.newyork.NewYorkStyleVeggiePizza;

public class DependentPizzaStore {

    Pizza orderPizza(String style, String type) {
        Pizza pizza = createPizza(style, type);

        // duplicated codes
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    private Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if ("NewYork".equals(style)) {
            if ("cheese".equals(type)) {
                pizza = new NewYorkStyleCheesePizza();
            } else if ("pepperoni".equals(type)) {
                pizza = new NewYorkStylePepperoniPizza();
            } else if ("clam".equals(type)) {
                pizza = new NewYorkStyleClamPizza();
            } else if ("veggie".equals(type)) {
                pizza = new NewYorkStyleVeggiePizza();
            }
        } else if("Chicago".equals(style)) {
            if ("cheese".equals(type)) {
                pizza = new ChicagoStyleCheesePizza();
            } else if ("pepperoni".equals(type)) {
                pizza = new ChicagoStylePepperoniPizza();
            } else if ("clam".equals(type)) {
                pizza = new ChicagoStyleClamPizza();
            } else if ("veggie".equals(type)) {
                pizza = new ChicagoStyleVeggiePizza();
            }
        } else if ("California".equals(style)) {
            if ("cheese".equals(type)) {
                pizza = new CaliforniaStyleCheesePizza();
            } else if ("pepperoni".equals(type)) {
                pizza = new CaliforniaStylePepperoniPizza();
            } else if ("clam".equals(type)) {
                pizza = new CaliforniaStyleClamPizza();
            } else if ("veggie".equals(type)) {
                pizza = new CaliforniaStyleVeggiePizza();
            }
        }
        return pizza;
    }
}
