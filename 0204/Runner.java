import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayTest at = new ArrayTest();
        ArrayList<Card> cardList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int rand = (int)(Math.random() * 9) + 1;
            cardList.add(new Card(rand));
        }

        at.printList(cardList);

        int total = at.findTotal(cardList);
        System.out.println("Total: " + total);
        System.out.println();

        at.scramble(cardList);
        at.printList(cardList);

        System.out.println("search and delete");
        at.searchAndDelete(cardList, 2);
        at.printList(cardList);

        System.out.println("search and replace");
        at.searchAndReplace(cardList, 4);
        at.printList(cardList);

        at.sort(cardList);
        at.printList(cardList);
    }
}