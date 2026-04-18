import java.util.Arrays;
import java.util.Random;

public class ArrayTest {
    private int[] numArray;

    public ArrayTest(int size) {
        numArray = new int[size];
        Random rand = new Random();

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = rand.nextInt(5); // 0 to 4
        }
    }

    public void printArray() {
        for (int num : numArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();
    }

    public int search(int target) {
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void scramble() {
        Random rand = new Random();

        for (int i = 0; i < numArray.length; i++) {
            int randomIndex = rand.nextInt(numArray.length);

            int temp = numArray[i];
            numArray[i] = numArray[randomIndex];
            numArray[randomIndex] = temp;
        }
    }

    public void sort() {
        Arrays.sort(numArray);
    }
}