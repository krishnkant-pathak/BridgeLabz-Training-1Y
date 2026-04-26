import java.util.*;

class Product {
    String name;
    double price;
    double rating;

    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}

public class EcommerceSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 80000, 4.5),
                new Product("Phone", 30000, 4.7),
                new Product("Tablet", 20000, 4.2)
        );

        products.sort((a, b) -> Double.compare(a.price, b.price));
        System.out.println("Sorted by Price:");
        products.forEach(p -> System.out.println(p.name));

        products.sort((a, b) -> Double.compare(b.rating, a.rating));
        System.out.println("Sorted by Rating:");
        products.forEach(p -> System.out.println(p.name));
    }
}
