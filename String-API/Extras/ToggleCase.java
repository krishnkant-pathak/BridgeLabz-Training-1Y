import java.util.Scanner;

public class ToggleCase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result = result + (char)(ch + 32);
            } 
            else if (ch >= 'a' && ch <= 'z') {
                result = result + (char)(ch - 32);
            } 
            else {
                result = result + ch;
            }
        }

        System.out.println("Toggled string: " + result);

        sc.close();
    }
}
