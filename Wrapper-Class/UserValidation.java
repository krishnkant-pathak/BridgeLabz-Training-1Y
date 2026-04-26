public class UserValidation {
    public static boolean isValid(String age) {
        try {
            int a = Integer.parseInt(age);
            return a >= 18;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("20"));
        System.out.println(isValid("abc"));
        System.out.println(isValid("15"));
    }
}