package checkpoint;

public abstract class Checkpoint {
    protected String id;
    protected String name;
    protected double distance;
    protected double expected;
    protected double actual;

    public Checkpoint(String id, String name, double d, double e, double a) {
        this.id = id;
        this.name = name;
        this.distance = d;
        this.expected = e;
        this.actual = a;
    }

    public boolean isDelayed() {
        return actual > expected;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isCritical();
    public abstract String getType();
    public abstract double calculatePenalty();
}
