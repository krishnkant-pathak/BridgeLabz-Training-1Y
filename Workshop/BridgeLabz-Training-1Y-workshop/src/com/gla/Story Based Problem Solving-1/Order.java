// Superclass
class Order {

    protected int orderId;
    protected double baseAmount;

    // Static delivery charge
    static double deliveryCharge = 40;

    // Constructor
    public Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    // Method to calculate bill (will be overridden)
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

// RegularOrder → No discount
class RegularOrder extends Order {

    public RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        return baseAmount + deliveryCharge;
    }
}

// PremiumOrder → 20% discount
class PremiumOrder extends Order {

    public PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        double discount = baseAmount * 0.20;
        return (baseAmount - discount) + deliveryCharge;
    }
}

// Main class to test polymorphism
public class FoodApp {

    public static void main(String[] args) {

        Order order1 = new RegularOrder(101, 500);
        Order order2 = new PremiumOrder(102, 500);

        System.out.println("Regular Order Bill: " + order1.calculateBill());
        System.out.println("Premium Order Bill: " + order2.calculateBill());
    }
}