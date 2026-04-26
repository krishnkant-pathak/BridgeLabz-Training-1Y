import java.util.Scanner;

public class AnagramCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine().toLowerCase();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine().toLowerCase();

        str1 = removeSpaces(str1);
        str2 = removeSpaces(str2);

        if (str1.length() != str2.length()) {
            System.out.println("The strings are not anagrams.");
        } else {
            int[] count = new int[256];

            for (int i = 0; i < str1.length(); i++) {
                count[str1.charAt(i)]++;
                count[str2.charAt(i)]--;
            }

            boolean isAnagram = true;

            for (int i = 0; i < 256; i++) {
                if (count[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram) {
                System.out.println("The strings are anagrams.");
            } else {
                System.out.println("The strings are not anagrams.");
            }
        }

        sc.close();
    }

    public static String removeSpaces(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result = result + str.charAt(i);
            }
        }
        return result;
    }
}
