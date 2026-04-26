public class SensorLogger {
    public static void log(double value) {
        Double obj = value; // auto-boxing
        double val = obj;   // auto-unboxing

        System.out.println("Logged value: " + val);
    }

    public static void main(String[] args) {
        log(25.6);
    }
}