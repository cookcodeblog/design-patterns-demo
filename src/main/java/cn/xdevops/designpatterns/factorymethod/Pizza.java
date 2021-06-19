package cn.xdevops.designpatterns.factorymethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings...");
        toppings.forEach(t -> System.out.println("  " + t));
    }

    public String getName() {
        return name;
    }
}
