public class Runner {

    public static void main(String[] args) {

        int[][] nums = new int[2][3];

        // fill with random numbers 1–9
        for (int r = 0; r < nums.length; r++) {
            for (int c = 0; c < nums[r].length; c++) {
                nums[r][c] = (int)(Math.random() * 9) + 1;
            }
        }

        Array2D a = new Array2D();

        a.print(nums);

        a.scramble(nums);

        a.print(nums);
    }
}