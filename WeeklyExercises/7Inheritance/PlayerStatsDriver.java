public class PlayerStatsDriver {
    public static void main(String[] args) {
        FootballStats f = new FootballStats();
        RugbyStats r = new RugbyStats();
        FootballStats f2 = new FootballStats("Ronaldo", 70, 4, 8, 300, 700, "ST");
        RugbyStats r2 = new RugbyStats("James", 4, 0, 80, 2, 6, "Scrum Half");

        System.out.println(f);
        System.out.println(r);
        System.out.println(f2);
        System.out.println(r2);

        System.out.println(f2.getName() + " " + f2.getWinLossRatio());
        System.out.println(r2.getName() + " " + r2.getWinLossRatio());

        System.out.println(f.getName() + " " + f.getGoalsScoredRatio());
        System.out.println(r.getName() + " " + r.getTriesScoredRatio());
    }
}
