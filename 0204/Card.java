import java.awt.Graphics;
public class Card {
    private int value;

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "Value: " + value;
    }

    public void drawMe(Graphics g, int x, int y) {
        g.drawRoundRect(x, y, 50, 70, 10, 10);
        g.drawString(Integer.toString(value), x + 20, y + 35);
    }
}