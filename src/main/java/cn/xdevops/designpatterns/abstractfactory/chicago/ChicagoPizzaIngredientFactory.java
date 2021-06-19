package cn.xdevops.designpatterns.abstractfactory.chicago;

import cn.xdevops.designpatterns.abstractfactory.*;
import cn.xdevops.designpatterns.factorymethod.chicago.*;


public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrusDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new EggPlant(), new Spinach(), new BlackOlives() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
