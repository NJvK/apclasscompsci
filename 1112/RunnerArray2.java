import java.util.Scanner;

public class RunnerArray2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayTest2 test = new ArrayTest2();

        int[] nums = test.createRandomArray(5);

        System.out.print("Array: ");
        test.printArray(nums);

        System.out.print("Enter a number to search for: ");
        int target = in.nextInt();

        int index = test.findIndex(nums, target);
        System.out.println("Index of " + target + ": " + index);

        int sum = test.getSum(nums);
        System.out.println("Sum of all numbers: " + sum);

        int[] doubled = test.getDoubledArray(nums);
        System.out.print("Doubled array: ");
        test.printArray(doubled);

        in.close();
    }
}
