import java.util.Scanner;
public class CircleRunner {
    Circle circle = new Circle();
    public static void main(String[] args) {
        CircleRunner circleRunner = new CircleRunner();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        int radius = scanner.nextInt();
        circleRunner.circle.circumference(radius);
        circleRunner.circle.area(radius);
    }   
}
