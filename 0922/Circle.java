public class Circle {
    private double radius;
    private double pi;
    private double area;
    private double cylinderVol;

    public Circle (){
        radius = 0;
        pi = Math.PI;
        area = Math.pow(radius, 2) * pi;
    }
    public Circle (double radius){
        this.radius = radius;
        pi = Math.PI;
        area = Math.pow(radius, 2) * pi;
    }
    public void area(){
        area = Math.pow(radius, 2) * pi;
        System.out.println("Area of Circle: " + area);
    }
    public void cylinderVol(double height){
        cylinderVol = Math.pow(radius,2) * pi * height;
        System.out.println("Volume of Cylinder: " + cylinderVol);
    }
}