package cn.xdevops.designpatterns.abstractfactory;

public abstract class Pizza {
    String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    abstract void prepare();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
