import java.time.*;
import java.util.*;

class Member {
    String name;
    LocalDate expiry;

    Member(String name, LocalDate expiry) {
        this.name = name;
        this.expiry = expiry;
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("A", LocalDate.now().plusDays(10)),
            new Member("B", LocalDate.now().plusDays(40))
        );

        members.stream()
            .filter(m -> m.expiry.isBefore(LocalDate.now().plusDays(30)))
            .forEach(m -> System.out.println(m.name));
    }
}
