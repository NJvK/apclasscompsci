public class Rectangle {
    private double area(double length, double width) {
        double area = length * width;
        return area;
    }
    public double volRect (double length, double width, double height) {
        area(length, width);
        double volRect = length * width * height;
        return volRect;
    }
}
