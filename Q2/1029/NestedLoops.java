public class NestedLoops {

    public void drawFilledBox() {
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void drawFilledBox(int width, int height) {
        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= width; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void drawMultiChart() {
        for (int row = 1; row <= 9; row++) {
            for (int col = 1; col <= 9; col++) {
                System.out.print((row * col) + "\t");
            }
            System.out.println();
        }
    }

    public void drawTriangle() {
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
