package checkpoint;

public class FuelCheckpoint extends Checkpoint {

    public FuelCheckpoint(String id, String name, double d, double e, double a) {
        super(id, name, d, e, a);
    }

    public boolean isCritical() { return true; }

    public String getType() { return "Fuel"; }

    public double calculatePenalty() {
        return isDelayed() ? 10 : 0;
    }
}
