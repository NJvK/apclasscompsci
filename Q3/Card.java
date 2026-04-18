import java.awt.*;

public class Card {
    // rank values: 11(J), 12(Q), 13(K), 14(A), 15(2 high)
    private int rank;
    private int suit; // 0=Clubs,1=Diamonds,2=Hearts,3=Spades

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean isThreeOfClubs() {
        return rank == 3 && suit == 0;
    }

    public String rankString() {
        if (rank >= 3 && rank <= 10) return "" + rank;
        if (rank == 11) return "J";
        if (rank == 12) return "Q";
        if (rank == 13) return "K";
        if (rank == 14) return "A";
        return "2";
    }

    public String suitString() {
        if (suit == 0) return "♣";
        if (suit == 1) return "♦";
        if (suit == 2) return "♥";
        return "♠";
    }

    public String shortName() {
        return rankString() + suitString();
    }

    public void draw(Graphics g, int x, int y, int w, int h, boolean selected) {
        if (selected) {
            g.setColor(new Color(255, 255, 180));
            g.fillRect(x, y, w, h);
        }

        g.setColor(Color.WHITE);
        g.fillRect(x, y, w, h);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, w, h);

        g.setFont(new Font("SansSerif", Font.BOLD, 16));
        g.drawString(shortName(), x + 8, y + 22);
    }
}