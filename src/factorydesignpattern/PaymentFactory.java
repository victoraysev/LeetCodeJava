package factorydesignpattern;

public class PaymentFactory {
    enum PaymentType {
        CREDITCARD,
        PAYPAL
    }

    public static Payment pay(PaymentType type) throws ClassNotFoundException {
        switch (type) {
            case CREDITCARD:
                return new CreditCardPayment();
            case PAYPAL:
                return new PaypalPayment();
            default:
                throw new ClassNotFoundException("Payment type not found");
        }
    }
}
