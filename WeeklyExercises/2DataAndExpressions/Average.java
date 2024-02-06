// *******************************************************************
//   Average.java
//
//   Read three integers from the user and print their average
// *******************************************************************


import java.util.Scanner;
public class Average
{
    public static void main(String[] args)
    {
        int val1, val2, val3;
        double average;
        Scanner scan = new Scanner(System.in) ;

        // get three values from user
        System.out.println("Please enter three integers and " +
                "I will compute their average");
        System.out.println("number 1 : ");
        val1 = scan.nextInt();
        System.out.println("number 2 : ");
        val2 = scan.nextInt();
        System.out.println("number 3 : ");
        val3 = scan.nextInt();

        //compute the average
        average = (double) (val1 + val2 + val3) / 3;

        //print the average
        System.out.println("Average = " + average);
    }
}