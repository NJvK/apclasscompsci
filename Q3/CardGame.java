import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    public static final int NUM_PLAYERS = 2;

    private ArrayList<Card> deck;
    private ArrayList<Card>[] hands;

    private int currentPlayer;

    private int prevRank;
    private int prevCount;

    private int lastPlayer;

    private boolean[] passed;

    private boolean gameOver;
    private int winner;

    @SuppressWarnings("unchecked")
    public CardGame() {

        hands = (ArrayList<Card>[]) new ArrayList[NUM_PLAYERS];

        for (int i = 0; i < NUM_PLAYERS; i++) {
            hands[i] = new ArrayList<Card>();
        }

        passed = new boolean[NUM_PLAYERS];

        newGame();
    }

    public void newGame() {

        deck = new ArrayList<Card>();

        // create deck
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 3; rank <= 15; rank++) {
                deck.add(new Card(rank, suit));
            }
        }

        Collections.shuffle(deck);

        // clear hands
        for (int i = 0; i < NUM_PLAYERS; i++) {
            hands[i].clear();
            passed[i] = false;
        }

        // deal cards
        for (int i = 0; i < deck.size(); i++) {
            hands[i % NUM_PLAYERS].add(deck.get(i));
        }

        // find who has 3 of clubs
        currentPlayer = 0;

        for (int p = 0; p < NUM_PLAYERS; p++) {
            for (Card c : hands[p]) {
                if (c.isThreeOfClubs()) {
                    currentPlayer = p;
                }
            }
        }

        prevRank = 0;
        prevCount = 0;

        lastPlayer = currentPlayer;

        gameOver = false;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Card> getHand(int player) {
        return hands[player];
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getWinner() {
        return winner;
    }

    public boolean canPlaySelected(ArrayList<Integer> selected) {

        if (selected.size() == 0) return false;

        ArrayList<Card> hand = hands[currentPlayer];

        int rank = hand.get(selected.get(0)).getRank();

        // check all cards same rank
        for (int i : selected) {
            if (hand.get(i).getRank() != rank) {
                return false;
            }
        }

        int count = selected.size();

        // 2 beats everything
        if (rank == 15) return true;

        // if no previous play
        if (prevCount == 0) return true;

        if (count < prevCount) return false;

        return rank > prevRank;
    }

    public boolean playSelected(ArrayList<Integer> selected) {

        if (!canPlaySelected(selected)) return false;

        ArrayList<Card> hand = hands[currentPlayer];

        int rank = hand.get(selected.get(0)).getRank();
        int count = selected.size();

        // remove cards
        for (int i = selected.size() - 1; i >= 0; i--) {
            hand.remove((int)selected.get(i));
        }

        prevRank = rank;
        prevCount = count;

        lastPlayer = currentPlayer;

        for (int i = 0; i < NUM_PLAYERS; i++) {
            passed[i] = false;
        }

        // check win
        if (hand.size() == 0) {
            gameOver = true;
            winner = currentPlayer;
            return true;
        }

        // special rule for 2
        if (rank == 15 && count == 1) {
            return true; // same player goes again
        }

        nextPlayer();

        return true;
    }

    public void passTurn() {

        passed[currentPlayer] = true;

        boolean allPassed = true;

        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (i != lastPlayer && !passed[i]) {
                allPassed = false;
            }
        }

        if (allPassed) {

            prevRank = 0;
            prevCount = 0;

            for (int i = 0; i < NUM_PLAYERS; i++) {
                passed[i] = false;
            }

            currentPlayer = lastPlayer;
        }

        else {
            nextPlayer();
        }
    }

    private void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % NUM_PLAYERS;
    }

    public void drawGameInfo(Graphics g, int width) {

        g.setColor(Color.BLACK);

        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        g.drawString("Player " + (currentPlayer + 1) + "'s turn", 20, 30);

        g.setFont(new Font("SansSerif", Font.PLAIN, 14));

        if (prevCount == 0) {
            g.drawString("Any play allowed", 20, 55);
        } else {
            g.drawString("Must beat: " + prevCount + " card(s) of rank " + prevRank, 20, 55);
        }

        int x = width - 180;

        g.drawString("Cards left:", x, 30);

        for (int i = 0; i < NUM_PLAYERS; i++) {
            g.drawString("Player " + (i + 1) + ": " + hands[i].size(), x, 50 + i * 18);
        }
    }
}