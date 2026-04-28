import java.util.*;
import checkpoint.*;

public class Driver {

    String id;
    String name;
    List<Checkpoint> route = new ArrayList<>();

    public Driver(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCheckpoint(Checkpoint c) {
        route.add(c);
    }

    public double totalDistance() {
        double sum = 0;
        for (Checkpoint c : route) sum += c.getDistance();
        return sum;
    }

    public double totalPenalty() {
        double sum = 0;
        for (Checkpoint c : route) sum += c.calculatePenalty();
        return sum;
    }

    public boolean checkCritical() {
        boolean hasDelivery = false;
        boolean hasFuel = false;

        for (Checkpoint c : route) {
            if (c.getType().equals("Delivery")) hasDelivery = true;
            if (c.getType().equals("Fuel")) hasFuel = true;
        }

        return hasDelivery && hasFuel;
    }

    public void printRoute() {
        int i = 1;
        for (Checkpoint c : route) {
            System.out.println(i + ". " + c.getType() + " - " + c.getName() +
                    (c.isDelayed() ? " - Delayed " : " - On Time ") +
                    " - Penalty: " + c.calculatePenalty());
            i++;
        }
    }

    public void printSummary() {
        System.out.println("Driver: " + id + " - " + name);
        System.out.println("Route Summary:");

        printRoute();

        double dist = totalDistance();
        double pen = totalPenalty();

        System.out.println("\nTotal Distance: " + dist);
        System.out.println("Total Penalty: " + pen);
        System.out.println("Score: " + (dist - pen));

        System.out.println("Critical Check: " +
            (checkCritical() ? "OK" : "Missing critical checkpoints"));
    }
}
