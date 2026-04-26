class Order {
    int orderId;
    double baseAmount;
    static double deliveryCharge = 40;

    Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

class RegularOrder extends Order {
    RegularOrder(int id, double amount) {
        super(id, amount);
    }
}

class PremiumOrder extends Order {
    PremiumOrder(int id, double amount) {
        super(id, amount);
    }

    double calculateBill() {
        return (baseAmount * 0.8) + deliveryCharge;
    }
}

public class FoodApp {
    public static void main(String[] args) {
        Order o1 = new RegularOrder(101, 500);
        Order o2 = new PremiumOrder(102, 500);

        System.out.println(o1.calculateBill());
        System.out.println(o2.calculateBill());
    }
}