import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(5) + 1;
        }

        PracticeQuiz pq = new PracticeQuiz();

        pq.print(nums);

        boolean hasThree = pq.contains(nums, 3);
        System.out.println("Array contains 3: " + hasThree);

        int product = pq.getProduct(nums);
        System.out.println("Product of all numbers: " + product);

        int largest = pq.getLargest(nums);
        System.out.println("Largest number: " + largest);
    }
}