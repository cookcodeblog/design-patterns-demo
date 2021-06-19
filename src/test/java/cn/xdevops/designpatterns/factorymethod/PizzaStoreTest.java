package cn.xdevops.designpatterns.factorymethod;

import cn.xdevops.designpatterns.factorymethod.california.*;
import cn.xdevops.designpatterns.factorymethod.chicago.*;
import cn.xdevops.designpatterns.factorymethod.newyork.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Pizza Test")
class PizzaStoreTest {

    @Test
    @DisplayName("Order a simple pizza")
    void orderSimplePizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza();
        assertNotNull(pizza);
    }

    @Test
    @DisplayName("Order your favor pizza type")
    void orderYourFavorPizza() {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        assertThat(pizzaStore.orderPizza("cheese")).isExactlyInstanceOf(CheesePizza.class);
        assertThat(pizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(PepperoniPizza.class);
        assertThat(pizzaStore.orderPizza("clam")).isExactlyInstanceOf(ClamPizza.class);
        assertThat(pizzaStore.orderPizza("veggie")).isExactlyInstanceOf(VeggiePizza.class);
    }

    @Test
    @DisplayName("Order your favor pizza type with your city style")
    void orderYourFavorPizzaWithYourCityStyle() {
        // NewYork Style pizzas
        PizzaStore nyPizzaStore = new PizzaStore(new NewYorkPizzaFactory());
        assertThat(nyPizzaStore.orderPizza("cheese")).isExactlyInstanceOf(NewYorkStyleCheesePizza.class);
        assertThat(nyPizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(NewYorkStylePepperoniPizza.class);
        assertThat(nyPizzaStore.orderPizza("clam")).isExactlyInstanceOf(NewYorkStyleClamPizza.class);
        assertThat(nyPizzaStore.orderPizza("veggie")).isExactlyInstanceOf(NewYorkStyleVeggiePizza.class);

        // Chicago Style pizzas
        PizzaStore chicagoPizzaStore = new PizzaStore(new ChicagoPizzaFactory());
        assertThat(chicagoPizzaStore.orderPizza("cheese")).isExactlyInstanceOf(ChicagoStyleCheesePizza.class);
        assertThat(chicagoPizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(ChicagoStylePepperoniPizza.class);
        assertThat(chicagoPizzaStore.orderPizza("clam")).isExactlyInstanceOf(ChicagoStyleClamPizza.class);
        assertThat(chicagoPizzaStore.orderPizza("veggie")).isExactlyInstanceOf(ChicagoStyleVeggiePizza.class);
        
        // California Style pizzas
        PizzaStore californiaPizzaStore = new PizzaStore(new CaliforniaPizzaFactory());
        assertThat(californiaPizzaStore.orderPizza("cheese")).isExactlyInstanceOf(CaliforniaStyleCheesePizza.class);
        assertThat(californiaPizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(CaliforniaStylePepperoniPizza.class);
        assertThat(californiaPizzaStore.orderPizza("clam")).isExactlyInstanceOf(CaliforniaStyleClamPizza.class);
        assertThat(californiaPizzaStore.orderPizza("veggie")).isExactlyInstanceOf(CaliforniaStyleVeggiePizza.class);

    }

    @Test
    @DisplayName("Order your favor pizza type in you local pizza store")
    void orderYourFavorPizzaInLocalStore() {
        // In NewYork pizza store
        AbstractPizzaStore nyPizzaStore = new NewYorkPizzaStore();
        assertThat(nyPizzaStore.orderPizza("cheese")).isExactlyInstanceOf(NewYorkStyleCheesePizza.class);
        assertThat(nyPizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(NewYorkStylePepperoniPizza.class);
        assertThat(nyPizzaStore.orderPizza("clam")).isExactlyInstanceOf(NewYorkStyleClamPizza.class);
        assertThat(nyPizzaStore.orderPizza("veggie")).isExactlyInstanceOf(NewYorkStyleVeggiePizza.class);

        // In Chicago pizza store
        AbstractPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        assertThat(chicagoPizzaStore.orderPizza("cheese")).isExactlyInstanceOf(ChicagoStyleCheesePizza.class);
        assertThat(chicagoPizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(ChicagoStylePepperoniPizza.class);
        assertThat(chicagoPizzaStore.orderPizza("clam")).isExactlyInstanceOf(ChicagoStyleClamPizza.class);
        assertThat(chicagoPizzaStore.orderPizza("veggie")).isExactlyInstanceOf(ChicagoStyleVeggiePizza.class);
        
        // In California pizza store
        AbstractPizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
        assertThat(californiaPizzaStore.orderPizza("cheese")).isExactlyInstanceOf(CaliforniaStyleCheesePizza.class);
        assertThat(californiaPizzaStore.orderPizza("pepperoni")).isExactlyInstanceOf(CaliforniaStylePepperoniPizza.class);
        assertThat(californiaPizzaStore.orderPizza("clam")).isExactlyInstanceOf(CaliforniaStyleClamPizza.class);
        assertThat(californiaPizzaStore.orderPizza("veggie")).isExactlyInstanceOf(CaliforniaStyleVeggiePizza.class);

    }

    @Test
    @DisplayName("Order your favor pizza type and style in a mixed pizza store")
    void orderYourFavorPizzaInMixedStore() {
        DependentPizzaStore dependentPizzaStore = new DependentPizzaStore();
        assertThat(dependentPizzaStore.orderPizza("NewYork", "cheese")).isExactlyInstanceOf(NewYorkStyleCheesePizza.class);
        assertThat(dependentPizzaStore.orderPizza("Chicago", "pepperoni")).isExactlyInstanceOf(ChicagoStylePepperoniPizza.class);
        assertThat(dependentPizzaStore.orderPizza("California", "clam")).isExactlyInstanceOf(CaliforniaStyleClamPizza.class);

    }

}