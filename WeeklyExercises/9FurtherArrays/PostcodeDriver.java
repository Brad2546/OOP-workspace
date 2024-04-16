import java.util.Arrays;
import java.util.Scanner;

public class PostcodeDriver {
    public static void main(String[] args) {
        PostcodeObj[] postcodes = new PostcodeObj[25];
        Scanner scan = new Scanner(System.in);
        int pointer = 0;

        System.out.println("Enter postcode info separated by a TAB... \t[Firstname]\t[Surname]\t[Postcode]): ");
        while (pointer<25) {
            System.out.println("Enter New Postcode (ENTER to stop) : ");
            String userInput = scan.nextLine();
            if (userInput.isEmpty()) {
                break;
            }

            String[] postCodeFields = userInput.split("\t");
            if (postCodeFields.length == 3) {
                postcodes[pointer] = new PostcodeObj(postCodeFields[0], postCodeFields[1], postCodeFields[2]);
                pointer++;
            } else {
                System.out.println("Invalid Input");
            }
        }

        for (PostcodeObj obj : postcodes) {
            if (obj == null) {
                break;
            } else {
                System.out.println(obj);
            }
        }
    }
}
