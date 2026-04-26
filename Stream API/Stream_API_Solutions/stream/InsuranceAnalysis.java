import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 1000),
            new Claim("Health", 2000),
            new Claim("Car", 3000)
        );

        Map<String, Double> avg = claims.stream()
            .collect(Collectors.groupingBy(
                c -> c.type,
                Collectors.averagingDouble(c -> c.amount)
            ));

        System.out.println(avg);
    }
}
