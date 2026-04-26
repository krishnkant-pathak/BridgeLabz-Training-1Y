import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    public static boolean isPalindromeUsingArray(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        boolean result1 = isPalindromeIterative(input);
        boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
        boolean result3 = isPalindromeUsingArray(input);

        System.out.println("Iterative Method: " + result1);
        System.out.println("Recursive Method: " + result2);
        System.out.println("Array Method: " + result3);

        sc.close();
    }
}
