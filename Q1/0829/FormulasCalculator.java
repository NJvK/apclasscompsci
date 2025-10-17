import java.lang.Math;
import java.util.Scanner;
public class FormulasCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pythagorean Theorem");
        double a, b, c;
        
        System.out.println("Enter a value for a");
        a = scan.nextDouble();
        
        System.out.println("Enter a value for b");
        b = scan.nextDouble();

        c = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("c = " + c);

        System.out.println("Area of a circle");
        
        double radius, area;
        System.out.println("Enter the radius");
        radius = scan.nextDouble();

        area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle = " + area);

        System.out.println("Area of a rectangle");
        
        double base, height, areaRect;
        System.out.println("Enter the base");
        base = scan.nextDouble();
        
        System.out.println("Enter the height");
        height = scan.nextDouble();

        areaRect = base * height;
        System.out.println("Area of the Rectangle = " + areaRect);

        System.out.println("Area of a square");
        System.out.println("Enter the side");
        double side = scan.nextDouble();
        double areaSquare = Math.pow(side, 2);
        System.out.println("Area of the square is = " + areaSquare);

        System.out.println("Volume of a cone");
        System.out.println("Enter the radius");
        double radiusCone = scan.nextDouble();
        System.out.println("Enter the height");
        double heightCone = scan.nextDouble();
        double volume = Math.PI * Math.pow(radiusCone, 2) * heightCone;
        System.out.println("volume: " + volume);
    }
}
