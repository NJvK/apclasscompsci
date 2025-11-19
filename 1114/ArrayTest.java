import java.util.Random;

public class ArrayTest {
    private int[] numbers;

    public ArrayTest(int size) {
        numbers = new int[size];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(9) + 1;
        }
    }

    public void print() {
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public int getSum() {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public int getLargest() {
        int largest = numbers[0];
        for (int n : numbers) {
            if (n > largest) {
                largest = n;
            }
        }
        return largest;
    }
}