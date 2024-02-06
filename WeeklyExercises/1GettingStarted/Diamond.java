
public class Diamond {

    String[] names = {""};
    public static void main(String[] args) {
        Diamond obj = new Diamond();
        obj.displayDiamond();
    }

    public void displayDiamond() {
        int i;
        for (i = -3; i < 4; i++) {
            int noOfSpaces = Math.abs(i);
            int noOfStars = 7 - noOfSpaces * 2;
            String test = " ".repeat(noOfSpaces) + "*".repeat(noOfStars);
            System.out.println(test);
        }
    }
}
