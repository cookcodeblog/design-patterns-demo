package cn.xdevops.designpatterns.strategy;

public class Order {
    private int paymentAmount = 0;
    private PayStrategy payStrategy;
    private boolean isPaid = false;

    public Order(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PayStrategy getPayStrategy() {
        return payStrategy;
    }

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void pay() {
        payStrategy.collectPaymentDetails();
        isPaid = payStrategy.pay(paymentAmount);
    }

    public boolean isPaid() {
        return isPaid;
    }

}
