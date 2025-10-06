// public class MathLibrary {
    // private double pi;

    // public MathLibrary() {
    //     this.pi = Math.PI;
    // }

    // public double getPi() {
    //     return pi;
    // }

    // public double circumference(double radius) {
    //     double circumference = 2 * pi * radius;
    //     return circumference;
    // }

    // public double areaOfCircle(double radius) {
    //     double area = pi * radius * radius;
    //     return area;
    // }

    // public double volOfCylinder(double radius, double height) {
    //     double volume = areaOfCircle(radius) * height;
    //     return volume;
    // }

    // public double volOfCone(double radius, double height) {
    //     double volume = (1.0 / 3.0) * areaOfCircle(radius) * height;
    //     return volume;
    // }

    // public double volOfSphere(double radius) {
    //     double volume = (4.0 / 3.0) * pi * Math.pow(radius, 3);
    //     return volume;
    // }

// }
public class MathLibrary {
    private double pi;

    public MathLibrary() {
        this.pi = 3.14159;
    }
    public double getPi() {
        return pi;
    }
    public double circumference(double radius) {
        double circumference = 2 * pi * radius;
        return circumference;
    }
    public double areaOfCircle(double radius) {
        double area = pi * radius * radius;
        return area;
    }
    public double volOfCylinder(double radius, double height) {
        double volume = areaOfCircle(radius) * height;
        return volume;
    }
    public double volOfCone(double radius, double height) {
        double volume = (1.0/3.0) * areaOfCircle(radius) * height;
        return volume;
    }
    public double volOfSphere(double radius) {
        double volume = (4.0/3.0) * pi * Math.pow(radius, 3);
        return volume;
    }
}