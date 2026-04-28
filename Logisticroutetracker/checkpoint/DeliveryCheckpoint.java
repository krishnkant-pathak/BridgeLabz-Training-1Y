package checkpoint;

public class DeliveryCheckpoint extends Checkpoint {

    public DeliveryCheckpoint(String id, String name, double d, double e, double a) {
        super(id, name, d, e, a);
    }

    public boolean isCritical() { return true; }

    public String getType() { return "Delivery"; }

    public double calculatePenalty() {
        if (!isDelayed()) return 0;
        return (actual - expected) * 2;
    }
}
