package cn.xdevops.designpatterns.factorymethod;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Tomato Sauce";

        toppings.add("Mozzarella Cheese");
    }
}
