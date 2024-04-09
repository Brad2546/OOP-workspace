import java.util.Scanner;

public class PlayerStats {

    String name;
    int matchesWon, matchesDrawn, matchesLost, matchesPlayed;
    private Scanner scan = new Scanner(System.in);

    public PlayerStats(String name, int matchesWon, int matchesDrawn, int matchesLost) {
        this.name = name;
        this.matchesWon = matchesWon;
        this.matchesDrawn = matchesDrawn;
        this.matchesLost = matchesLost;
        this.matchesPlayed = matchesDrawn + matchesLost + matchesWon;
    }

    public PlayerStats() {
        setName(getUserInput("Name"));
        setMatchesWon(Integer.parseInt(getUserInput("Matches Won")));
        setMatchesDrawn(Integer.parseInt(getUserInput("Matches Drawn")));
        setMatchesLost(Integer.parseInt(getUserInput("Matches Lost")));
        this.matchesPlayed = matchesDrawn + matchesLost + matchesWon;
    }

    public String getUserInput(String inputText) {
        System.out.println("Enter " + inputText + " : ");
        return scan.nextLine();
    }

    public double getWinLossRatio() {
        return (double) matchesWon / matchesLost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesDrawn() {
        return matchesDrawn;
    }

    public void setMatchesDrawn(int matchesDrawn) {
        this.matchesDrawn = matchesDrawn;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", matchesWon=" + matchesWon +
                ", matchesDrawn=" + matchesDrawn +
                ", matchesLost=" + matchesLost + ", ";
    }
}
