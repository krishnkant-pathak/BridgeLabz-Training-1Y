interface SecurityUtils {
    static boolean isStrong(String password) {
        return password.length() >= 8;
    }
}

public class PasswordCheck {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrong("Password123"));
    }
}