public class FootballStats extends PlayerStats {

    int goalsScored, passes;
    String position;

    public FootballStats(String name, int matchesWon, int matchesDrawn, int matchesLost, int goalsScored, int passes, String position) {
        super(name, matchesWon, matchesDrawn, matchesLost);
        this.goalsScored = goalsScored;
        this.passes = passes;
        this.position = position;
    }

    public FootballStats() {
        super();
        setGoalsScored(Integer.parseInt(getUserInput("Goals scored")));
        setPosition(getUserInput("Position"));
        setPasses(Integer.parseInt(getUserInput("Passes made")));
    }

    public double getGoalsScoredRatio() {
        return (double) this.matchesPlayed / this.goalsScored;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                super.toString() +
                "goalsScored=" + goalsScored +
                ", passes=" + passes +
                ", position='" + position + '\'' +
                '}';
    }
}
