import java.util.ArrayList;

public class ArrayTest {
    public void printList(ArrayList<Card> cards) {
        for (Card cd : cards) {
            System.out.println(cd);
        }
        System.out.println();
    }

    public int findTotal(ArrayList<Card> cards) {
        int total = 0;
        for (Card cd : cards) {
            total += cd.getValue();
        }
        return total;
    }

    public void searchAndDelete(ArrayList<Card> cards, int value) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue() == value) {
                cards.remove(i);
                i--;
            }
        }
    }

    public void scramble(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            int randIndex = (int)(Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randIndex));
            cards.set(randIndex, temp);
        }
    }

    public void searchAndReplace(ArrayList<Card> cards, int value) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue() == value) {
                cards.set(i, new Card(99));
                break;
            }
        }
    }

    public void sort(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = 0; j < cards.size() - 1 - i; j++) {
                if (cards.get(j).getValue() > cards.get(j + 1).getValue()) {
                    Card temp = cards.get(j);
                    cards.set(j, cards.get(j + 1));
                    cards.set(j + 1, temp);
                }
            }
        }
    }
}