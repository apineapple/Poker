import java.util.ArrayList;

public class Deck {
    public static void main(String[] args) {
        int players = 3;
        String player[][] = new String[players][2];
        ArrayList<String> shuffled = new ArrayList<String>();
        String[] SUITS = {
                "Clubs", "Diamonds", "Hearts", "Spades"
        };

        String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        // initialize deck
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // print shuffled deck
        for (int i = 0; i < n; i++) {
            shuffled.add(deck[i]);
        }
        for(int i = 0; i < players; i++){
            player[i][0] = shuffled.get(0);
            player[i][1] = shuffled.get(1);
            shuffled.remove(0);
            shuffled.remove(1);
        }
        for(int i = 0; i < players; i++){
            System.out.println("Player " + Integer.toString(i + 1) + ": " + player[i][0] + ", " + player[i][1]);
        }
    }
    private static String getFace(String x){
        return x.substring(x.indexOf(" ") + 4, x.length());
    }
    private static int getValue(String x){
        String value = x.substring(0, x.indexOf(" "));
        switch (value){
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 1;
            default:
                return Integer.parseInt(value);

        }
    }
}
