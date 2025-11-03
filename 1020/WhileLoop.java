import java.util.Scanner;
public class WhileLoop {
    public static void main(String[] args) {
        int num8 = 8;
        int sum1 = 0;
        int num2 = 2;
        int sum2 = 0;
        Scanner scanner = new Scanner(System.in);
        while (num8 <= 30) {
            System.out.print(num8);
            num8 += 2;
        };
        do {
            System.out.println(num8);
            num8 += 2;
        } while (num8 <= 30);
        // ------------------------------------------------
        while (num2 <= 19) {
            sum1 += num2;
            num2 ++;
        };
        System.out.println("The sum is: " + sum1);
        sum2 = 0;
        num2 = 2;
        do {
            sum2 += num2;
            num2 ++;
        } while (num2 <= 19);
        System.out.println("The sum is: " + sum2);
        // ------------------------------------------------
        System.out.print("Enter an integer: ");
        int num3 = scanner.nextInt();
        if (num3 < 0) {
            System.out.println("Negative number entered.");
        } else if (num3 > 0) {
            System.out.print("Positive number entered.");
        } else {
            System.out.println("Zero entered.");
        }
        scanner.close();
    }
}