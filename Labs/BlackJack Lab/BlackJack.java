import java.util.Random;

public class BlackJack {
    private Card[] deck;
    private int deckIndex;

    private Card[] hand;
    private int handSize;

    private boolean gameOver;
    private boolean stood;

    private int points;
    private int lastWinPoints;

    private Random rng;

    public BlackJack() {
        deck = new Card[52];
        hand = new Card[12]; // with A=11 only, you bust fast; 12 is plenty
        rng = new Random();

        points = 20;
        newGame(); // costs 1 point per lab, so we immediately start a first game
    }

    public void newGame() {
        if (points <= 0) {
            gameOver = true;
            stood = true;
            lastWinPoints = 0;
            return;
        }

        points -= 1;
        lastWinPoints = 0;
        gameOver = false;
        stood = false;

        buildDeck();
        shuffleDeck();
        deckIndex = 0;

        handSize = 0;
        dealToHand();
        dealToHand();

        if (getHandValue() > 21) {
            gameOver = true;
            stood = true;
        }
    }

    private void buildDeck() {
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        String[] names = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int[] values   = { 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 ,10 ,10 ,10 ,11};

        int idx = 0;
        for (int s = 0; s < suits.length; s++) {
            for (int n = 0; n < names.length; n++) {
                deck[idx] = new Card(suits[s], names[n], values[n]);
                idx++;
            }
        }
    }

    private void shuffleDeck() {
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    private Card drawCard() {
        if (deckIndex >= deck.length) return null;
        Card c = deck[deckIndex];
        deckIndex++;
        return c;
    }

    private void dealToHand() {
        Card c = drawCard();
        if (c == null) return;
        hand[handSize] = c;
        handSize++;
    }

    public void hit() {
        if (gameOver) return;

        dealToHand();

        if (getHandValue() > 21) {
            gameOver = true;
            stood = true;
            lastWinPoints = 0;
        }
    }

    public void stand() {
        if (gameOver) return;

        stood = true;
        gameOver = true;

        int total = getHandValue();
        lastWinPoints = calcWinPoints(total);

        if (lastWinPoints > 0) {
            points += lastWinPoints;
        }
    }

    private int calcWinPoints(int total) {
        if (total > 21) return 0;
        if (total < 16) return 0;

        if (total == 21) return 5;
        if (total == 20) return 3;
        if (total == 19) return 2;
        if (total == 18) return 2;
        if (total == 17) return 1;
        if (total == 16) return 1;

        return 0;
    }

    public int getHandValue() {
        int sum = 0;
        for (int i = 0; i < handSize; i++) {
            sum += hand[i].getValue();
        }
        return sum;
    }

    public Card[] getHand() {
        return hand;
    }

    public int getHandSize() {
        return handSize;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean hasStood() {
        return stood;
    }

    public int getPoints() {
        return points;
    }

    public int getLastWinPoints() {
        return lastWinPoints;
    }

    public String getEndMessage() {
        int total = getHandValue();

        if (!gameOver) return "Game in progress...";

        if (total > 21) return "BUST. You went over 21.";
        if (total < 16) return "You stood under 16. You lose.";
        if (lastWinPoints > 0) return "You win " + lastWinPoints + " point(s)!";
        return "You lose.";
    }
}
