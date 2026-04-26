import java.util.Scanner;

class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array size:");
        int n = sc.nextInt();

        int marks[] = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        System.out.println("Array in reverse order:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(marks[i]);
        }

       
    }
}
