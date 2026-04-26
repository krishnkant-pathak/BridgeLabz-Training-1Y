class Order implements Runnable {
    private String id;
    private int time;

    public Order(String id, int time) {
        this.id = id;
        this.time = time;
    }

    public void run() {
        try {
            System.out.println(id + " Picked Up");
            Thread.sleep(time * 1000);
            System.out.println(id + " In Transit");
            Thread.sleep(time * 1000);
            System.out.println(id + " Delivered");
        } catch (InterruptedException e) {}
    }
}

public class Problem3_FoodDeliverySystem {
    public static void main(String[] args) {
        Thread o1 = new Thread(new Order("Order1", 2));
        Thread o2 = new Thread(new Order("Order2", 3));
        Thread o3 = new Thread(new Order("Order3", 1));
        Thread o4 = new Thread(new Order("Order4", 4));
        Thread o5 = new Thread(new Order("Order5", 2));

        o1.setPriority(10);
        o2.setPriority(5);
        o3.setPriority(3);
        o4.setPriority(5);
        o5.setPriority(3);

        o1.start();
        o2.start();
        o3.start();
        o4.start();
        o5.start();
    }
}