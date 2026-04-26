import java.util.Scanner;

public class UniqueCharacters {

    public static int findLength(String text) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            count++;
        }
        return count;
    }

    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);
        char[] temp = new char[length];
        int index = 0;

        for (int i = 0; i < length; i++) {

            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index] = current;
                index++;
            }
        }

        char[] unique = new char[index];

        for (int i = 0; i < index; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        char[] uniqueChars = findUniqueCharacters(input);

        System.out.println("Unique Characters:");

        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }

        sc.close();
    }
}
