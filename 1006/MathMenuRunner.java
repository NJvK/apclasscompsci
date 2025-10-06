import java.util.Scanner;

public class MathMenuRunner {
    public static void main(String[] args) {
        MathLibrary mathLib = new MathLibrary();
        Scanner scanner = new Scanner(System.in);

        // Display the menu
        System.out.println("Select a calculation:");
        System.out.println("1. Circumference");
        System.out.println("2. Area of a Circle");
        System.out.println("3. Volume of a Sphere");
        System.out.println("4. Volume of a Cylinder");
        System.out.println("5. Volume of a Cone");
        System.out.print("Enter your choice (1-5): ");

        int choice = scanner.nextInt();
        double radius, height;

        // Perform the calculation based on the user's choice
        switch (choice) {
            case 1:
                System.out.print("Enter the radius: ");
                radius = scanner.nextDouble();
                System.out.println("Circumference: " + mathLib.circumference(radius));
                break;
            case 2:
                System.out.print("Enter the radius: ");
                radius = scanner.nextDouble();
                System.out.println("Area of Circle: " + mathLib.areaOfCircle(radius));
                break;
            case 3:
                System.out.print("Enter the radius: ");
                radius = scanner.nextDouble();
                System.out.println("Volume of Sphere: " + mathLib.volOfSphere(radius));
                break;
            case 4:
                System.out.print("Enter the radius: ");
                radius = scanner.nextDouble();
                System.out.print("Enter the height: ");
                height = scanner.nextDouble();
                System.out.println("Volume of Cylinder: " + mathLib.volOfCylinder(radius, height));
                break;
            case 5:
                System.out.print("Enter the radius: ");
                radius = scanner.nextDouble();
                System.out.print("Enter the height: ");
                height = scanner.nextDouble();
                System.out.println("Volume of Cone: " + mathLib.volOfCone(radius, height));
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }

        scanner.close();
    }
}