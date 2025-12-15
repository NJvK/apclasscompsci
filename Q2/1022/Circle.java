public class Circle {
    private double pi;

    public Circle() {
        this.pi = Math.PI;
    }
    private double getArea(double radius) {
        return pi * radius * radius;
    }
    public double volCircle(double radius, double height) {
        return getArea(radius) * height;
    }
}
