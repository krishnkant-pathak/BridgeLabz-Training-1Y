import java.util.Scanner;

public class WordAnalyzer {

    public static String[] splitText(String text) {
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        String temp = "";
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                temp += ch;
            } else if (!temp.equals("")) {
                words[index++] = temp;
                temp = "";
            }
        }

        if (!temp.equals("")) {
            words[index] = temp;
        }

        return words;
    }

    public static int findLength(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            count++;
        }
        return count;
    }

    public static String[][] create2DArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static int[] findShortestAndLongest(String[][] data) {
        int minIndex = 0;
        int maxIndex = 0;

        int minLength = Integer.parseInt(data[0][1]);
        int maxLength = Integer.parseInt(data[0][1]);

        for (int i = 1; i < data.length; i++) {
            int len = Integer.parseInt(data[i][1]);

            if (len < minLength) {
                minLength = len;
                minIndex = i;
            }

            if (len > maxLength) {
                maxLength = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] words = splitText(input);
        String[][] data = create2DArray(words);
        int[] result = findShortestAndLongest(data);

        System.out.println("Shortest Word: " + data[result[0]][0]);
        System.out.println("Longest Word: " + data[result[1]][0]);

        sc.close();
    }
}
