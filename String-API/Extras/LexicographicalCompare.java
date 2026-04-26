import java.util.Scanner;

public class LexicographicalCompare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int minLength = str1.length() < str2.length() ? str1.length() : str2.length();
        int result = 0;

        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 != ch2) {
                result = ch1 - ch2;
                break;
            }
        }

        if (result == 0) {
            if (str1.length() == str2.length()) {
                System.out.println("Both strings are equal.");
            } else if (str1.length() < str2.length()) {
                System.out.println("First string comes before second string.");
            } else {
                System.out.println("First string comes after second string.");
            }
        } else if (result < 0) {
            System.out.println("First string comes before second string.");
        } else {
            System.out.println("First string comes after second string.");
        }

        sc.close();
    }
}
