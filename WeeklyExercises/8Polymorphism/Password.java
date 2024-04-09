import java.util.Scanner;

public class Password implements Encryptable {

    private String message, key;
    private Scanner scanner;
    private boolean encrypted;

    public Password(String plainTxt) {
        scanner = new Scanner(System.in);
        message = plainTxt;
        String potentialkey = "";
        while (potentialkey.length() != message.length()) {
            System.out.println("Enter Key (must be same length as message (demo is 11 char long)): ");
            potentialkey = scanner.nextLine();
        }
        key = potentialkey;
        encrypted = false;
    }

    @Override
    public void encrypt() {
        if (!encrypted) {
            String masked = "";
            for (int i=0; i<message.length(); i++) {
                int asciiValue = (int) message.charAt(i) + (int) key.charAt(i);
                if (asciiValue > 126) {
                    asciiValue = asciiValue - 126 + 32;
                }
                masked = masked + (char) asciiValue;
            }
            message = masked;
            encrypted = true;
        }
    }

    @Override
    public String decrypt() {
        if (encrypted) {
            String unmasked = "";
            for (int i=0; i<message.length(); i++) {
                int asciiValue = (int) message.charAt(i) - (int) key.charAt(i);
                if (asciiValue <= 32) {
                    asciiValue = asciiValue + 126 - 32;
                }
                unmasked = unmasked + (char) asciiValue;
            }
            message = unmasked;
            encrypted = false;
        }
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
