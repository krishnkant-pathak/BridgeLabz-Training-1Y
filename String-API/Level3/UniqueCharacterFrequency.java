import java.util.Scanner;

public class UniqueCharacterFrequency {

    public static char[] uniqueCharacters(String text) {

        char[] temp = new char[text.length()];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {

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

    public static String[][] findFrequency(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        char[] unique = uniqueCharacters(text);

        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[][] data = findFrequency(input);

        System.out.println("Character\tFrequency");
        System.out.println("----------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }

        sc.close();
    }
}
