public class Triangle {
    private double base = 0.0;
    private double height = 0.0;
    private double area;
    public Triangle() {
        area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
    public void setDimensions(double b, double h) {
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
