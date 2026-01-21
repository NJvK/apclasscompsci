import java.util.Random;

public class ArrayTest2 {

    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
        System.out.println();
    }

    public int search(int target, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public void scramble(int[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndex = rand.nextInt(arr.length);

            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}