package checkpoint;

public class RestCheckpoint extends Checkpoint {

    public RestCheckpoint(String id, String name, double d, double e, double a) {
        super(id, name, d, e, a);
    }

    public boolean isCritical() { return false; }

    public String getType() { return "Rest"; }

    public double calculatePenalty() {
        if (!isDelayed()) return 0;
        double delay = actual - expected;
        return delay > 30 ? delay * 0.5 : 0;
    }
}
