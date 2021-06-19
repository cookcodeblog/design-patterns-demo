package cn.xdevops.designpatterns.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Pay Order Test")
class OrderTest {

    @Test
    @DisplayName("Pay order using PayPal")
    void payOrderUsingPayPal() {
        Order order = new Order(6940);
        order.setPayStrategy(new PayByPayPal());

        // before pay
        assertThat(order.isPaid()).isFalse();
        order.pay();
        // after pay
        assertThat(order.isPaid()).isTrue();
    }


    @Test
    @DisplayName("Pay order using credit card")
    void payOrderUsingCreditCard() {
        Order order = new Order(11530);
        order.setPayStrategy(new PayByCreditCard());

        // before pay
        assertThat(order.isPaid()).isFalse();
        order.pay();
        // after pay
        assertThat(order.isPaid()).isTrue();
    }

}