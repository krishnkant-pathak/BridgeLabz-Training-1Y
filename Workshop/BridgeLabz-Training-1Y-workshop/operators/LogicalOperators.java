import java.util.Scanner;

public class LogicalOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean a = sc.nextBoolean();
        boolean b = sc.nextBoolean();

        System.out.println(a && b);
        System.out.println(a || b);
        System.out.println(!a);
    }
}

