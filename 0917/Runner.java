import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Circle circle1 = new Circle();
        Rectangle rectangle1 = new Rectangle();
        Triangle triangle1 = new Triangle();
        Square square1 = new Square();

        Square square2 = new Square(4.0);
        square2.printVariables();
        square2.area();

        Rectangle rectangle2 = new Rectangle(5.0, 3.0);
        rectangle2.printVariables();
        rectangle2.area();

        Triangle triangle2 = new Triangle(5.0, 3.0);
        triangle2.printVariables();
        triangle2.area();

        Circle circle2 = new Circle(4.0);
        circle2.printVariables();
        circle2.area();

        System.out.println("Choose a shape to calculate the area: ");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Square");

        int choice = scan.nextInt();
        if (choice == 1){
            System.out.print("Enter the radius of the circle: ");
            double radius = scan.nextDouble();
            Circle circle3 = new Circle(radius);
            circle3.area();
        } else if (choice == 2){
            System.out.print("Enter the length of the rectangle: ");
            double length = scan.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = scan.nextDouble();
            Rectangle rectangle3 = new Rectangle(length, width);
            rectangle3.area();
        } else if (choice == 3){
            System.out.print("Enter the base of the triangle: ");
            double base = scan.nextDouble();
            System.out.print("Enter the height of the triangle: ");
            double height = scan.nextDouble();
            Triangle triangle3 = new Triangle(base, height);
            triangle3.area();
        } else if (choice == 4){
            System.out.print("Enter the side length of the square: ");
            double side = scan.nextDouble();
            Square square3 = new Square(side);
            square3.area();
        } else {
            System.out.println("Invalid choice");
        }
    }
}
