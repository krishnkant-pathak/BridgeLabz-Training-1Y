import java.util.*;
import java.util.function.Function;

class Invoice {
    int id;

    Invoice(int id) {
        this.id = id;
    }

    public String toString() {
        return "Invoice ID: " + id;
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {

        List<Integer> transactionIds = Arrays.asList(1, 2, 3);

        Function<Integer, Invoice> creator = Invoice::new;

        transactionIds.stream()
                .map(creator)
                .forEach(System.out::println);
    }
}
