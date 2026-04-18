public class Card {
    private String suit;   // Diamonds, Hearts, Spades, Clubs
    private String name;   // "2", "3", ... "10", "J", "Q", "K", "A"
    private int value;     // 2-11 (A is always 11 in this lab)

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getDisplay() {
        return name + " of " + suit;
    }
}
