import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Square Square = new Square();

        Square.setDimensions(4.0);
        Square.printVariables();
        Square.area();

        rectangle.setDimensions(5.0, 3.0);
        rectangle.printVariables();
        rectangle.area();

        triangle.setDimensions(5.0, 3.0);
        triangle.printVariables();
        triangle.area();

        circle.setRadius(4.0);
        circle.printVariables();
        circle.area();

        System.out.println("Choose a shape to calculate the area: ");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Square");

        int choice = scan.nextInt();
        if (choice == 1){
            System.out.print("Enter the radius of the circle: ");
            double radius = scan.nextDouble();
            circle.setRadius(radius);
            circle.area();
        } else if (choice == 2){
            System.out.print("Enter the length of the rectangle: ");
            double length = scan.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = scan.nextDouble();
            rectangle.setDimensions(length, width);
            rectangle.area();
        } else if (choice == 3){
            System.out.print("Enter the base of the triangle: ");
            double base = scan.nextDouble();
            System.out.print("Enter the height of the triangle: ");
            double height = scan.nextDouble();
            triangle.setDimensions(base, height);
            triangle.area();
        } else if (choice == 4){
            System.out.print("Enter the side length of the square: ");
            double side = scan.nextDouble();
            Square.setDimensions(side);
            Square.area();
        } else {
            System.out.println("Invalid choice");
        }
    }
}
