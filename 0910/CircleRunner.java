import java.util.Scanner;
public class CircleRunner {
    Circle circle = new Circle();
    public static void main(String[] args) {
        CircleRunner circleRunner = new CircleRunner();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        int radius = scanner.nextInt();
        circleRunner.circle.Circumference(radius);
        circleRunner.circle.Area(radius);
    }   
}
