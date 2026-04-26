import java.util.Scanner;

public class DeckOfCards {

    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber = i + (int)(Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    public static String[][] distributeCards(String[] deck, int playersCount, int cardsPerPlayer) {

        int totalCardsNeeded = playersCount * cardsPerPlayer;

        if (totalCardsNeeded > deck.length) {
            return null;
        }

        String[][] players = new String[playersCount][cardsPerPlayer];

        int index = 0;

        for (int i = 0; i < playersCount; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index];
                index++;
            }
        }

        return players;
    }

    public static void printPlayers(String[][] players) {

        if (players == null) {
            System.out.println("Cards cannot be distributed.");
            return;
        }

        for (int i = 0; i < players.length; i++) {

            System.out.println("Player " + (i + 1) + " Cards:");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                          "Jack", "Queen", "King", "Ace"};

        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int playersCount = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = sc.nextInt();

        String[][] players = distributeCards(deck, playersCount, cardsPerPlayer);

        printPlayers(players);

        sc.close();
    }
}
