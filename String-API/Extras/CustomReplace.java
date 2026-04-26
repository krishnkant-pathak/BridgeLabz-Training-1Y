import java.util.Scanner;

public class CustomReplace {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = sc.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = sc.nextLine();

        String result = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified sentence: " + result);

        sc.close();
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {

        String result = "";

        for (int i = 0; i <= sentence.length() - oldWord.length(); ) {

            boolean match = true;

            for (int j = 0; j < oldWord.length(); j++) {
                if (sentence.charAt(i + j) != oldWord.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                result = result + newWord;
                i = i + oldWord.length();
            } else {
                result = result + sentence.charAt(i);
                i++;
            }
        }

        while (result.length() < sentence.length()) {
            result = result + sentence.charAt(result.length());
        }

        return result;
    }
}
