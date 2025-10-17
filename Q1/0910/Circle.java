import java.lang.Math;
public class Circle {
    public void circumference(int r) {
        double c = 2 * Math.PI * r;
        System.out.println("Circumference: " + c);
    }
    public void area(int r) {
        double a = Math.PI * r * r;
        System.out.println("Area: " + a);
    }
}
