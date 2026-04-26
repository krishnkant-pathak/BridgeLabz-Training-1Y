import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@gmail.com", "b@gmail.com");

        emails.forEach(email -> System.out.println("Sending email to " + email));
    }
}
