import java.util.Scanner;

public class MyMath {
    Scanner scanner = new Scanner(System.in);
    int num;
    public void EvenOrOdd() {
        System.out.print("Enter an integer: ");
        this.num = scanner.nextInt();
        num = (num % 2);
        if (num == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public void quadraticFormula() {
        System.out.println("What is your a value? : ");
        double a = scanner.nextDouble();
        System.out.println("What is youre b value? : ");
        double b = scanner.nextDouble();
        System.out.println("What is youre c value? : ");
        double c = scanner.nextDouble();
        double discriminant = b * b - 4 * a * c;
        System.out.println("Youre equation is: " + a + "x^2 + " + b +"x + " + "c");
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("The roots are real and different.");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            System.out.println("There is 1 solution");
            double root = -b / (2 * a);
            System.out.println("Root = " + root);
            
        } else {
            System.out.println("The roots are undifined.");
            
        }

        
    }

}
