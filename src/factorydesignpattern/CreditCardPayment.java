package factorydesignpattern;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Credit Card Payment for:" + amount);
    }
}
