import java.util.Arrays;

public class StudentGrades {

    public static void main(String[] args) {
        StudentGrades obj = new StudentGrades();
        String[][] studentData = {
                {"Brad","8","3"},
                {"Bobby","7","7"},
                {"James","10","2"},
                {"Zack","100","1"},
                {"Paul Lean","0","50"}
        };
        obj.displayGrades(studentData);
    }

    public void displayGrades(String[][] studentData) {
        System.out.println("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n"
        + "==          Student Points          ==\n"
        + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////\n");

        String tableHeaderTitles = String.format("%-18s %-6s %-6s %-6s","Name","Lab","Bonus","Total");
        String tableHeaderBorder = String.format("%-18s %-6s %-6s %-6s","----","---","-----","-----");
        System.out.println(tableHeaderTitles);
        System.out.println(tableHeaderBorder);

        for (int i = 0; i < studentData.length; i++) {
            String name = studentData[i][0];
            int labMark = Integer.parseInt(studentData[i][1]);
            int bonusMark = Integer.parseInt(studentData[i][2]);
            int totalMark = labMark + bonusMark;

            String displayData = String.format("%-18s %-6d %-6d %-6d", name, labMark, bonusMark, totalMark);
            System.out.println(displayData);
        }
    }
}
