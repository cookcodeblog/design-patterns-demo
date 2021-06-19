package cn.xdevops.designpatterns.factorymethod.newyork;

import cn.xdevops.designpatterns.factorymethod.Pizza;

public class NewYorkStyleCheesePizza extends Pizza {

    public NewYorkStyleCheesePizza() {
        name = "NewYork Style Sauce and cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
