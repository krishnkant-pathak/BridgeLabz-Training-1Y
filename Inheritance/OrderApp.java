class Order {
    int orderId;
    String orderDate;

    Order(int id, String date) {
        this.orderId = id;
        this.orderDate = date;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int id, String date, String tracking) {
        super(id, date);
        this.trackingNumber = tracking;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int id, String date, String tracking, String deliveryDate) {
        super(id, date, tracking);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OrderApp {
    public static void main(String[] args) {
        Order o = new DeliveredOrder(1, "01-01-2024", "TRK123", "05-01-2024");
        System.out.println(o.getOrderStatus());
    }
}