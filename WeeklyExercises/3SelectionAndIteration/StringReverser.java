import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        String text;
        StringBuilder reversedText = new StringBuilder();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter string to reverse: ");
        text = scan.nextLine();

        Scanner search = new Scanner(text);
        while (search.hasNext()) {
            String nextString = search.next();
            reversedText.append(reverseWord(nextString));
            if (search.hasNext()) {
                reversedText.append(" ");
            }
        }
        reversedText.append(".");
        scan.close();

        System.out.println("Reversed string is...");
        System.out.println(reversedText);
    }

    public static StringBuilder reverseWord(String word) {
        StringBuilder reversedWord = new StringBuilder();
        int wordLength = word.length();
        for (int index = wordLength -1; index >= 0; index = index - 1) {
            reversedWord.append(word.charAt(index));
        }
        return reversedWord;
    }
}
