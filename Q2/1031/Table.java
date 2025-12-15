public class Table {
    private int rows;
    private int cols;
    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
    public void drawBox() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
