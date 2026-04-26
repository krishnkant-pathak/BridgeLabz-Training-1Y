import java.util.Scanner;

public class SubstringCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = sc.nextLine();

        System.out.print("Enter the substring to search: ");
        String subString = sc.nextLine();

        int count = 0;

        for (int i = 0; i <= mainString.length() - subString.length(); i++) {

            boolean found = true;

            for (int j = 0; j < subString.length(); j++) {
                if (mainString.charAt(i + j) != subString.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                count++;
            }
        }

        System.out.println("Substring occurs " + count + " times.");

        sc.close();
    }
}
