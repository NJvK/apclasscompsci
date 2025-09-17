import java.lang.Math;
public class Circle {
    private double radius = 0.0;
    private double pi = Math.PI;
    private double area;
    public Circle() {
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    public Circle (double r) {
        radius = r;
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    public void printVariables() {
        System.out.println("Radius: " + radius);
        System.out.println("Pi: " + pi);
    }
    public double area() {
        area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
        return area;
    }
}
