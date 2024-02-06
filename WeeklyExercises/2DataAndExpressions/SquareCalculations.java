import java.util.Scanner;

public class SquareCalculations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n"
                + "==         Square Calculator        ==\n"
                + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////\n");

        int edgeLen, perimeter, area;
        System.out.println("Enter Length of Square --↴");
        edgeLen = scan.nextInt();

        perimeter = 4 * edgeLen;
        area = edgeLen * edgeLen;
        String displayString = String.format("Sqaure with length %s has...\nPerimeter = %s\nArea = %s",edgeLen,perimeter,area);
        System.out.println(displayString);
    }
}
