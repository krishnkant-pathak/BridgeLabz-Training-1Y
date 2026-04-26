interface SensitiveData {}

class User implements SensitiveData {
    String password = "secret";
}

public class MarkerDemo {
    public static void main(String[] args) {
        User u = new User();
        System.out.println(u instanceof SensitiveData);
    }
}