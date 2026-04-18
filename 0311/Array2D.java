public class Array2D {

    // print the 2D array as a table
    public void print(int[][] arr) {

        for (int r = 0; r < arr.length; r++) {

            for (int c = 0; c < arr[r].length; c++) {
                System.out.print(arr[r][c] + "\t");
            }

            System.out.println();
        }

        System.out.println();
    }


    // scramble the values in the 2D array
    public void scramble(int[][] arr) {

        for (int r = 0; r < arr.length; r++) {

            for (int c = 0; c < arr[r].length; c++) {

                int randRow = (int)(Math.random() * arr.length);
                int randCol = (int)(Math.random() * arr[0].length);

                int temp = arr[r][c];
                arr[r][c] = arr[randRow][randCol];
                arr[randRow][randCol] = temp;
            }
        }
    }
}