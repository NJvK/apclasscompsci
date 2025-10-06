import java.util.Scanner;
public class RunnerMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyMath myMath = new MyMath();
        int choice;
        System.out.println("Which method do you want? type 1 for even or odd and type 2 for quadratic.");
        choice = scanner.nextInt();
        if (choice == 1) {
            myMath.EvenOrOdd();
        } else if (choice == 2) {
            myMath.quadraticFormula();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
