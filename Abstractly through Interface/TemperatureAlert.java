import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> alert = temp -> temp > 40;
        System.out.println(alert.test(45.0));
    }
}