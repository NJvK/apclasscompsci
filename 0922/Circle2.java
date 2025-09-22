public class Circle2 {
    private double radius;
    private double pi;

    public Circle2(){
        radius = 0;
        pi = Math.PI;
    }
    public Circle2(double radius){
        this.radius = radius;
        pi = Math.PI;
    }
    public void printArea1(){
        double area = Math.pow(radius, 2) * pi;
        System.out.println("Area of Circle: " + area);
    }
    public void printArea2(double radius){
        double area = Math.pow(radius, 2) * pi;
        System.out.println("Area of Circle: " + area);  
    }
    public void printVol1(double radius){
        this.radius = radius;
        double vol = 4/3 * Math.pow(radius,3) * pi;
        System.out.println("Volume of Sphear: " + vol);
    }
    public void printVol2(double radius, double height){
        double vol = Math.pow(radius,2) * pi * height;
        System.out.println("Volume of Cylinder: " + vol);
    }

}
