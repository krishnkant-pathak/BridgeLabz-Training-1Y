class Product {
    int productId;
    String productName;

    Product(int id, String name) {
        this.productId = id;
        this.productName = name;
    }

    boolean isMatch(String keyword) {
        return productName.contains(keyword);
    }
}

class ElectronicProduct extends Product {
    String brand;

    ElectronicProduct(int id, String name, String brand) {
        super(id, name);
        this.brand = brand;
    }

    boolean isMatch(String keyword) {
        return productName.contains(keyword) || brand.equalsIgnoreCase(keyword);
    }
}

public class ProductApp {
    public static void main(String[] args) {
        Product p = new ElectronicProduct(1, "Laptop", "Dell");
        System.out.println(p.isMatch("Dell"));
    }
}