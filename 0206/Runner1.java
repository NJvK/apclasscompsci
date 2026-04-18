import java.util.ArrayList;

public class Runner1 {
    public static void main(String[] args) {
        ArrayList<Item> itemList = new ArrayList<>();

        itemList.add(new Item("Cereal", 4.99));
        itemList.add(new Item("Milk", 3.99));
        itemList.add(new Item("Water", 0.99));

        double total = 0.0;
        for (Item i : itemList) {
            total += i.getPrice();
        }
        System.out.println("Total price: $" + total);

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getPrice() == 0.99) {
                String name = itemList.get(i).getName();
                itemList.set(i, new Item(name, 1.25));
            }
        }

        for (Item i : itemList) {
            System.out.println(i);
        }
    }
} 