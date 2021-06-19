package cn.xdevops.designpatterns.abstractfactory;

import cn.xdevops.designpatterns.abstractfactory.chicago.ChicagoPizzaStore;
import cn.xdevops.designpatterns.abstractfactory.newyork.NewYorkPizzaStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Pizza Test")
class PizzaStoreTest {

    @Test
    @DisplayName("Order your favor pizza in local store")
    void orderYourFavorPizzaInLocalStore() {
        // NewYork style pizzas
        PizzaStore nyStore = new NewYorkPizzaStore();
        assertThat(nyStore.orderPizza("cheese"))
                .isExactlyInstanceOf(CheesePizza.class)
                .matches(p -> "New York Style Cheese Pizza".equals(p.getName()), "Pizza Name");

        // Chicago style pizzas
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        assertThat(chicagoStore.orderPizza("veggie"))
                .isExactlyInstanceOf(VeggiePizza.class)
                .matches(p -> "Chicago Style Veggie Pizza".equals(p.getName()), "Pizza Name");
    }
}