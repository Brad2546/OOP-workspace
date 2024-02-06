import java.util.Scanner;

public class Fraction{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n"
                + "==             Fraction             ==\n"
                + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////\n");

        int numerator, denominator;
        System.out.println("Enter numerator (top) --↴");
        numerator = scan.nextInt();
        System.out.println("Enter denominator (bottom) --↴");
        denominator = scan.nextInt();

        double decimal;
        decimal = ((double) numerator / denominator);
        String displayString = String.format("%d/%d = %f",numerator,denominator,decimal);
        System.out.println(displayString);
    }
}
