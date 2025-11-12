import java.util.Random;

public class RunnerArray3 {
    public static void main(String[] args) {
        ArrayTest3 at = new ArrayTest3();

        int[] nums = new int[10];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(9) + 1;
        }

        at.printArray(nums);

        boolean found1 = at.searchNumber1(5, nums);
        System.out.println("Does 5 exist? " + found1);

        int index = at.searchNumber2(5, nums);
        System.out.println("Index of 5: " + index);

        int largest = at.findLargest(nums);
        System.out.println("Largest number: " + largest);

        int smallest = at.findSmallest(nums);
        System.out.println("Smallest number: " + smallest);

        int total = at.sum(nums);
        System.out.println("Sum of all numbers: " + total);

        int product = at.product(nums);
        System.out.println("Product of all numbers: " + product);
    }
}