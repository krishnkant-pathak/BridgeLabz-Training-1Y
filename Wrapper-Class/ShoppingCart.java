public class ShoppingCart {
    public static void main(String[] args) {
        String[] prices = {"250", "499", "abc", "99"};

        int total = 0;

        for (String p : prices) {
            try {
                total += Integer.parseInt(p);
            } catch (Exception e) {
                System.out.println("Invalid: " + p);
            }
        }

        System.out.println("Total = " + total);
    }
}