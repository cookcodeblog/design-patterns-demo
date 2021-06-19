package cn.xdevops.designpatterns.strategy;

public class PayByCreditCard implements PayStrategy {
    private boolean signedIn;

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using credit card.");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Collecting payment details of credit card.");
        System.out.println("Please choose a credit card...");
        System.out.println("Please input your password...");
        signedIn = true;
    }
}
