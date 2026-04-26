import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;

    Alert(String type) {
        this.type = type;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Emergency"),
                new Alert("Reminder"),
                new Alert("Warning")
        );

        Predicate<Alert> filter = a -> a.type.equals("Emergency");

        alerts.stream()
                .filter(filter)
                .forEach(a -> System.out.println(a.type));
    }
}
