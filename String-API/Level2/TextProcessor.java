import java.util.Scanner;

class TextProcessor {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] words = splitText(input);
        String[][] output = create2DArray(words);

        System.out.println("Word\tLength");

        for (int i = 0; i < output.length; i++) {
            int len = Integer.parseInt(output[i][1]);
            System.out.println(output[i][0] + "\t" + len);
        }

        sc.close();
    }
}
