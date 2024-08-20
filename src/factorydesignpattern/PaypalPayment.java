package factorydesignpattern;

public class PaypalPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paypal Payment for:" + amount);
    }
}
