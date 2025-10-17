public class Triangle {
    private double base;
    private double height;
    private double area;
    public Triangle() {
        base = 0.0;
        height = 0.0;
    }
    public Triangle (double b, double h) {
        base = b;
        height = h;
    }
    public double area() {
        area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
        return area;
    }
    public void printVariables() {
        System.out.println("Base: " + base);
        System.out.println("Height: " + height);
    }
}
