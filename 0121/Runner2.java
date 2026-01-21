import java.util.Random;
import java.util.Scanner;

public class Runner2 {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(10) + 1;
        }

        ArrayTest2 at = new ArrayTest2();

        at.printArray(nums);

        at.scramble(nums);
        at.printArray(nums);

        System.out.print("Enter a number to search for: ");
        int searchNum = scan.nextInt();

        int location = at.search(searchNum, nums);
        System.out.println(location);

        at.sort(nums);
        at.printArray(nums);
    }
}