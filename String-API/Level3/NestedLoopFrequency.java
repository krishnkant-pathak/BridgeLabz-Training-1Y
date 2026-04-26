import java.util.Scanner;

public class NestedLoopFrequency {

    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {
                continue;
            }

            freq[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] frequencyData = findFrequency(input);

        System.out.println("Character Frequencies:");
        System.out.println("----------------------");

        for (int i = 0; i < frequencyData.length; i++) {
            System.out.println(frequencyData[i]);
        }

        sc.close();
    }
}
