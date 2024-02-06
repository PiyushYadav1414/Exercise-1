import java.util.Random;
import java.util.Scanner;

/**
 * Author: [Piyush Yadav]
 * Date: [6/02/2023]
 */
public class Card {
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private String[] hand = new String[7];
    private Random random = new Random();

    public Card() {
        generateHand();
    }

    private void generateHand() {
        for (int i = 0; i < hand.length; i++) {
            String suit = suits[random.nextInt(suits.length)];
            String value = values[random.nextInt(values.length)];
            hand[i] = value + " of " + suit;
        }
    }

    public void pickCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card (e.g., 'Ace of Hearts'): ");
        String userCard = scanner.nextLine();

        boolean cardFound = false;
        for (String card : hand) {
            if (card.equals(userCard)) {
                cardFound = true;
                break;
            }
        }

        if (cardFound) {
            System.out.println("Your card is in the hand.");
            printInfo();
        } else {
            System.out.println("Your card is not in the hand.");
        }
    }

    public void printInfo() {
        System.out.println("Hand:");
        for (String card : hand) {
            System.out.println(card);
        }
    }

    public static void main(String[] args) {
        Card cardTrick = new Card();
        cardTrick.pickCard();
    }
}
