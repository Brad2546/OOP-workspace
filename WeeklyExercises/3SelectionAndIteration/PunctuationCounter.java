import java.util.Scanner;

public class PunctuationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fullStopCount = 0;
        int commaCount = 0;
        int dashCount = 0;
        String[] validPunctuation = {".",",","-"};
        String text;
        int textLength;

        System.out.println("Enter String to count punctuation: ");
        text = scan.nextLine();
        textLength = text.length();

        for (int index = 0; index < textLength; index++) {
            String thisChar = String.valueOf(text.charAt(index));
            switch (thisChar) {
                case ".":
                    fullStopCount++;
                    break;
                case ",":
                    commaCount++;
                    break;
                case "-":
                    dashCount++;
                    break;
            }
        }

        System.out.println("The string contains...");
        System.out.println(fullStopCount + "x \" . \" (full-stop),");
        System.out.println(commaCount + "x \" , \" (comma),");
        System.out.println(dashCount + "x \" - \" (dash),");

    }
}
