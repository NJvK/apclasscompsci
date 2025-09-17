public class Rectangle {
    private double length = 0.0;
    private double width = 0.0;
    private double area;
    public Rectangle() {
        area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
    public Rectangle (double l, double w) {
        length = l;
        width = w;
    }
    public double area() {
        area =length * width;
        System.out.println("Area of Rectangle: " + area);
        return area;
    }
    public void printVariables() {
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }
}
