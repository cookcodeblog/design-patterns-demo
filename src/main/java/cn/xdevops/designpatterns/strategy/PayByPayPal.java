package cn.xdevops.designpatterns.strategy;

public class PayByPayPal implements PayStrategy {
    private boolean signedIn;

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Collecting payment details of PayPal.");
        System.out.println("Please input your password...");
        signedIn = true;
    }
}
