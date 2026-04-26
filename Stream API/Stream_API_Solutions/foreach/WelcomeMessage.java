import java.util.*;

public class WelcomeMessage {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Ansh", "Rahul");
        attendees.forEach(a -> System.out.println("Welcome " + a));
    }
}
