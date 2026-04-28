import checkpoint.*;

public class Main {
    public static void main(String[] args) {

        Driver d = new Driver("D1204", "Kavita Nair");

        d.addCheckpoint(new DeliveryCheckpoint("1","Warehouse A",40,60,70));
        d.addCheckpoint(new FuelCheckpoint("2","Pump 12",20,30,30));
        d.addCheckpoint(new RestCheckpoint("3","Motel X",10,30,35));
        d.addCheckpoint(new DeliveryCheckpoint("4","Client Hub",50,80,95));

        d.printSummary();
    }
}
