public class ArrayTest {
    private int[] nums;

    public ArrayTest() {
        nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 99) + 1;
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] + " ";
        }
        return result;
    }

    public void sort() {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}