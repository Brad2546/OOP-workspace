public class RugbyStats extends PlayerStats {

    int triesScored, tacklesMade;
    String position;

    public RugbyStats(String name, int matchesWon, int matchesDrawn, int matchesLost, int triesScored, int tacklesMade, String position) {
        super(name, matchesWon, matchesDrawn, matchesLost);
        this.triesScored = triesScored;
        this.tacklesMade = tacklesMade;
        this.position = position;
    }

    public RugbyStats() {
        super();
        setTriesScored(Integer.parseInt(getUserInput("Tries scored")));
        setPosition(getUserInput("Position"));
        setTacklesMade(Integer.parseInt(getUserInput("Tackles made")));
    }

    public double getTriesScoredRatio() {
        return (double) this.matchesPlayed / this.triesScored;
    }

    public int getTriesScored() {
        return triesScored;
    }

    public void setTriesScored(int triesScored) {
        this.triesScored = triesScored;
    }

    public int getTacklesMade() {
        return tacklesMade;
    }

    public void setTacklesMade(int tacklesMade) {
        this.tacklesMade = tacklesMade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "RugbyStats{" +
                super.toString() +
                "trysScored=" + triesScored +
                ", tacklesMade=" + tacklesMade +
                ", position='" + position + '\'' +
                '}';
    }
}


