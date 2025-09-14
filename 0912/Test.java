import java.util.Scanner;
import java.lang.Math;
public class Test {
        private double pi = 0;
        private int radius = 0;
         private Scanner scan = new Scanner(System.in);
    
    public void setVariable() {
        System.out.print("Enter radius: ");
        radius = scan.nextInt();
        pi = Math.PI;
    }
    public void c() {
        double c = 2 * pi * radius;
        System.out.println("Circumference: " + c);
    }
    public void a(){
        double a = pi * radius * radius;
        System.out.println("Area: " + a);
    }
}