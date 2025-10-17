import java.lang.Math;
import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter in the height for the cylinder");
        double height,radius,volume;
        height = scan.nextDouble();

        System.out.println("Enter in the radius for the cylinder");
        radius = scan.nextDouble();

        volume = Math.PI * Math.pow(radius,2) * height;
        System.out.println("Voluem = " + volume);

        System.out.println("What is the capital of georga");
        String answer = scan.next();
        if (answer.equals("Tablici")){
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect it is Tablici");
        }
    }
}
