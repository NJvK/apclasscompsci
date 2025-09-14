
import java.util.Scanner;
import java.lang.Math;
public class Fromulas {
    Scanner scanner = new Scanner(System.in);
    private int getChoice = scanner.nextInt();
    public int getChoice() {
        return getChoice;
    }
    private double pi = 0;
    private double radius = 0;
    private double side = 0;
    private double length = 0;
    private double width = 0;
    private double a = 0;
    private double b = 0;
    private double c = 0;
    private double height = 0;
    public void setVariable() {
        pi = Math.PI;
        System.out.print("Enter radius: ");
        radius = scanner.nextInt();
        System.out.print("Enter side: ");
        side = scanner.nextInt();
        System.out.print("Enter length: ");
        length = scanner.nextInt();
        System.out.print("Enter width: ");
        width = scanner.nextInt();
        System.out.print("Enter a: ");
        a = scanner.nextInt();
        System.out.print("Enter b: ");
        b = scanner.nextInt();
        System.out.print("Enter Degree: ");
        c = scanner.nextDouble();
        System.out.print("Enter height: ");
        height = scanner.nextDouble();
    }
    public void c() { // circumference
        System.out.println("Given radius: " + radius + " find circumference");
        double c = 2 * pi * radius;
        System.out.println("Circumference: " + c);
    }
    public void a(){ // area Circle
        double a = pi * radius * radius;
        System.out.println("Area: " + a);
    }
    public void s() { // area square
        double r = Math.pow(side, 2);
        System.out.println("Area of Rectangle: " + r);
    }
    public void t() { // area triangle
        double t = 0.5 * a * b * Math.sin(c);
        System.out.println("Area of Triangle: " + t);
    }
    public void r() { // area rectangle
        double r = length * width;
        System.out.println("Area of Rectangle: " + r);
    }
    public void p() { // perimeter rectangle
        double p = 2 * (length + width);
        System.out.println("Perimeter of Rectangle: " + p);
    }
    public void pS(){ // perimeter square
        double pS = 4 * side;
        System.out.println("Perimeter of Square: " + pS);
    }
    public void average(){ // average of two numbers
        double avg = (a + b) / 2;
        System.out.println("Average: " + avg);
    }
    public void pythagorean(){ // Pythagorean theorem
        double c = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("c = " + c);
    }
    public void vCone(){ // area of a cone
        double volume = (1.0/3.0) * pi * Math.pow(radius, 2) * height;
        System.out.println("Volume of Cone: " + volume);
    }
    public void cimport(){ // how to import in c++
        System.out.println("#include <iostream>");
    }
    public void define(){ // how to define pi in c++
        System.out.println("#define PI 3.14");
    }
    public void vPyraimid(){ // how to do variables in c++
        System.out.println("int main() {");
            System.out.println(" int a = 10;");
            System.out.println(" int b = 3;");
            System.out.println(" return 0;");
    }
    public void sSphere(){ // how to add in c++
        System.out.println("std::cout << 10 + 3 =  << a + b << std::endl;");
    }
    public void aTrapizoid(){ // how to devide in c++
        System.out.println("std::cout << 10 + 3 =  << a / b << std::endl;");
    }

}
