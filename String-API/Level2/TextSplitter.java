import java.util.Scanner;
class TextSplitter {
    public static int findLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }
    public static String[] manualSplit(String str) {
        int len = findLength(str);
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words[index++] = str.substring(start, i);
                start = i + 1;
            }
        }
        if (wordCount > 0)
            words[index] = str.substring(start, len);
        return words;
    }
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();
        String[] manualResult = manualSplit(text);
        String[] builtInResult = text.split(" ");
        System.out.println("Manual Split Result:");
        for (int i = 0; i < manualResult.length; i++)
            System.out.println(manualResult[i]);
        System.out.println("Built-in Split Result:");
        for (int i = 0; i < builtInResult.length; i++)
            System.out.println(builtInResult[i]);
        boolean result = compareArrays(manualResult, builtInResult);
        System.out.println("Are both results same? " + result);
    }
}
