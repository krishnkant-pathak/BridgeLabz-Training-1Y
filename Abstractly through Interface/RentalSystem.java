interface Rentable {
    void rent();
    void returnVehicle();
}

class Car implements Rentable {
    public void rent() { System.out.println("Car Rented"); }
    public void returnVehicle() { System.out.println("Car Returned"); }
}

public class RentalSystem {
    public static void main(String[] args) {
        Rentable r = new Car();
        r.rent();
        r.returnVehicle();
    }
}