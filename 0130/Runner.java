import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        ArrayTest at = new ArrayTest();
        ArrayList<Integer> myList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            myList.add((int)(Math.random() * 10) + 1);
        }

        at.print(myList);
        at.sort(myList);
        at.print(myList);
    }
}