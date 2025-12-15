import java.util.Random;

public class ArrayTest2 {
    public int findIndex(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public int[] getDoubledArray(int[] arr) {
        int[] doubled = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            doubled[i] = arr[i] * 2;
        }
        return doubled;
    }
    public int[] createRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }
        return arr;
    }
    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
