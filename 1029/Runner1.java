import java.util.Scanner;

public class Runner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NestedLoops nestedLoops = new NestedLoops();

        System.out.println("10x10 Filled Box:");
        nestedLoops.drawFilledBox();

        System.out.print("\nEnter width of box: ");
        int width = scanner.nextInt();
        System.out.print("Enter height of box: ");
        int height = scanner.nextInt();

        System.out.println("\nFilled Box (" + width + "x" + height + "):");
        nestedLoops.drawFilledBox(width, height);

        System.out.println("\nMultiplication Chart (1–9):");
        nestedLoops.drawMultiChart();

        System.out.println("\nRight Triangle:");
        nestedLoops.drawTriangle();

        scanner.close();
    }
}