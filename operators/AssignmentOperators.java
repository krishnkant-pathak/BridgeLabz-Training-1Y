import java.util.Scanner;

public class AssignmentOperators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        a += 5;
        a -= 2;
        a *= 2;
        a /= 3;

        System.out.println(a);
    }
}
