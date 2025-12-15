import java.util.Random;
public class Runner {
    public static void main(String[] args) {
        Random random = new Random();
        Test test = new Test();
        int [] nums = new int [5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(5) + 1;
        }
        test.print(nums);
        test.find(nums, 3);
        test.getSummation(nums);
        test.getSmallest(nums);
    }
}