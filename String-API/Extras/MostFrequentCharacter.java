import java.util.Scanner;

public class MostFrequentCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int maxCount = 0;
        char mostFrequent = ' ';

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int count = 0;

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = ch;
            }
        }

        System.out.println("Most frequent character: " + mostFrequent);
        System.out.println("Frequency: " + maxCount);

        sc.close();
    }
}
