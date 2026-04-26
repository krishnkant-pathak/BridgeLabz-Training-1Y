import java.time.*;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {
        List<Integer> ids = Arrays.asList(1,2,3);

        ids.forEach(id -> 
            System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
