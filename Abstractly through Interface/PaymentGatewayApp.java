interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refunded: " + amount);
    }
}

class PayPal implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid: " + amount);
    }
}

public class PaymentGatewayApp {
    public static void main(String[] args) {
        PaymentProcessor p = new PayPal();
        p.pay(1000);
        p.refund(500);
    }
}