package cn.xdevops.designpatterns.factorymethod;

public class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    Pizza orderPizza() {
        // default is cheese pizza
        return orderPizza("cheese");
    }

    Pizza orderPizza(String type) {
//        Pizza pizza = StaticPizzaFactory.createPizza(type);
        Pizza pizza = factory.createPizza(type);

        // duplicated codes
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
