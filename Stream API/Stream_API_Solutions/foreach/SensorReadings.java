import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(10, 50, 80);

        readings.stream()
            .filter(r -> r > 40)
            .forEach(System.out::println);
    }
}
