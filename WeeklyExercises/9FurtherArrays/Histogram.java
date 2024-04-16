import java.util.Arrays;
import java.util.Scanner;

public class Histogram {

    public static void main(String[] args) {

        int[] valueList = new int[100];
        int nextIndex = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter number 1-100 (0 to stop): ");
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            if (value > 100 || value < 1) {
                System.out.println("! Number out of bounds !");
                continue;
            }
            valueList[nextIndex] = value;
            nextIndex++;
        }
        System.out.println(Arrays.toString(valueList));

        int[] countArray = {0,0,0,0,0,0,0,0,0,0};
        for (int eachValue : valueList) {
            if (eachValue == 0) {
                break;
            }
            int valueIndex = (eachValue-1) / 10;
            countArray[valueIndex] += 1;
        }

        int lowerBound = 1;
        for (int eachCount : countArray) {
            String bar = "*".repeat(eachCount);
            System.out.println(lowerBound+" - "+(lowerBound+9)+" | "+bar);
            lowerBound+=10;
        }
    }
}
