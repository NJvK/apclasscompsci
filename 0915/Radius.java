public class Radius {
    private double pi = 0;
    public void setVariable() {
        pi = Math.PI;
    }
    public void printArea(double radius) {
        double a = pi * radius * radius;
        System.out.println("Area: " + a);
    }
    public void printCircumference(double radius) {
        double c = 2 * pi * radius;
        System.out.println("Circumference: " + c);
    }
    public void printConeVolume(double radius, double height) {
        double v = (1.0/3.0) * pi * radius * radius * height;
        System.out.println("Volume of Cone: " + v);
    }
}
