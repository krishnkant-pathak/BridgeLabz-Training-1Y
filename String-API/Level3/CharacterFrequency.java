import java.util.Scanner;

public class CharacterFrequency {

    public static String[][] findFrequency(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] != 0) {
                count++;
                frequency[ch] = -frequency[ch];
            }
        }

        String[][] result = new String[count][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] < 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(-frequency[ch]);
                frequency[ch] = 0;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[][] frequencyData = findFrequency(input);

        System.out.println("Character\tFrequency");
        System.out.println("----------------------------");

        for (int i = 0; i < frequencyData.length; i++) {
            System.out.println(frequencyData[i][0] + "\t\t" + frequencyData[i][1]);
        }

        sc.close();
    }
}
