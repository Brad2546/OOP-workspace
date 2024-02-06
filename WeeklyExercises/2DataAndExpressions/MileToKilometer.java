import java.util.Scanner;

public class MileToKilometer {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n"
                + "==            Mile to Km            ==\n"
                + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////\n");

        double kilometers;
        System.out.println("Enter Miles --↴");
        double miles = scan.nextDouble();
        kilometers = 1.60935 * miles;
        System.out.println(miles + " miles ---> " + kilometers + " kilometers");

    }
}
