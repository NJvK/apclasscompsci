public class Square {
    private double sideLength = 0.0;
    private double area = 0.0;
    public Square() {
        area = sideLength * sideLength;
        System.out.println("Area of Square: " + area);
    }
    public void setDimensions(double side) {
        sideLength = side;
    }
    public void printVariables() {
        System.out.println("Side Length: " + sideLength);
    }
    public double area() {
        area = sideLength * sideLength;
        System.out.println("Area of Square: " + area);
        return area;
    }
}
