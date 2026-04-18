import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test {
    private ArrayList<Integer> numList;

    public Test() {
        numList = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            numList.add(rand.nextInt(10) + 1); // 1 to 10
        }
    }

    public void printList() {
        for (int num : numList) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    public int searchLargest() {
        int largest = numList.get(0);

        for (int num : numList) {
            if (num > largest) {
                largest = num;
            }
        }

        return largest;
    }

    public void searchAndReplace(int target) {
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == target) {
                numList.set(i, 1000);
            }
        }
    }

    public void searchAndRemove(int target) {
        for (int i = numList.size() - 1; i >= 0; i--) {
            if (numList.get(i) == target) {
                numList.remove(i);
            }
        }
    }

    public void sort() {
        Collections.sort(numList);
    }
}