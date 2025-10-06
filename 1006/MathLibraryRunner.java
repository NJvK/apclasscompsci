import java.util.Scanner;
public class MathLibraryRunner {
    public static void main(String[] args) {
        MathLibrary mathLib = new MathLibrary();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter height: ");
        double height = scanner.nextDouble();

        System.out.println("Value of Pi: " + mathLib.getPi());
        System.out.println("Circumference of circle with radius " + radius + ": " + mathLib.circumference(radius));
        System.out.println("Area of circle with radius " + radius + ": " + mathLib.areaOfCircle(radius));
        System.out.println("Volume of cylinder with radius " + radius + " and height " + height + ": " + mathLib.volOfCylinder(radius, height));
        System.out.println("Volume of cone with radius " + radius + " and height " + height + ": " + mathLib.volOfCone(radius, height));
        System.out.println("Volume of sphere with radius " + radius + ": " + mathLib.volOfSphere(radius));
    }
}
