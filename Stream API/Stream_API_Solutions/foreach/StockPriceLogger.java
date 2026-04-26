import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(100.5, 200.75, 150.0);
        prices.forEach(System.out::println);
    }
}
