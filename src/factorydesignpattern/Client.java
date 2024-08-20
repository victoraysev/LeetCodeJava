package factorydesignpattern;

// the aim for factory pattern is,
// not to create an object, but to create an interface
// not exposing the class creation details to the client
public class Client {

    public static void main(String[] args) {
        Payment payment = null;
        try {
            payment = PaymentFactory.pay(PaymentFactory.PaymentType.CREDITCARD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        payment.pay(100);
    }
}
