import java.util.Random;

public class PlayingCard {

    static Random rand = new Random();
    private int value;
    private String house;
    private String face;

    public PlayingCard() {
        setHouse(generateRandomHouse());
        setFace(generateRandomFace());
        setValue(getFaceValue());
    }

    private String generateRandomHouse() {
        int randomInt = rand.nextInt(4);
        return switch (randomInt) {
            case 0 -> "Spades";
            case 1 -> "Clubs";
            case 2 -> "Hearts";
            case 3 -> "Diamonds";
            default -> null;
        };
    }

    private String generateRandomFace() {
        int randomInt = rand.nextInt(13);
        return switch (randomInt) {
            case 0 -> "A";
            case 1 -> "2";
            case 2 -> "3";
            case 3 -> "4";
            case 4 -> "5";
            case 5 -> "6";
            case 6 -> "7";
            case 7 -> "8";
            case 8 -> "9";
            case 9 -> "10";
            case 10 -> "J";
            case 11 -> "Q";
            case 12 -> "K";
            default -> null;
        };
    }

        private int getFaceValue () {
            return switch (getFace()) {
                case "A" -> 1;
                case "J", "K", "Q" -> 10;
                default -> Integer.parseInt(getFace());
            };
        }

        // -----------------------------
        // setters
        // -----------------------------

        public void setValue ( int value){
            this.value = value;
        }

        public void setHouse (String house){
            this.house = house;
        }

        public void setFace (String face){
            this.face = face;
        }

        // -----------------------------
        // getters
        // -----------------------------

        public int getValue () {
            return value;
        }

        public String getHouse () {
            return house;
        }

        public String getFace () {
            return face;
        }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "value=" + value +
                ", house='" + house + '\'' +
                ", face='" + face + '\'' +
                '}';
    };
}
