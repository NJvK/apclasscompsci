import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Bank bank = new Bank("Natalie", 1000);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your selection (1-5): \n1. Print Name \n2. Print Balance \n3. Deposit \n4. Withdraw \n5. Exit");

        while (true) {
            int selection = scanner.nextInt();
            
            if (selection == 1) {
                bank.printName();
            } else if (selection == 2) {
                bank.printBalance();
            } else if (selection == 3) {
                System.out.println("How much would you like to deposit?");
                double depositAmount = scanner.nextDouble();
                bank.deposit(depositAmount);
            } else if (selection == 4) {
                System.out.println("How much would you like to withdraw?");
                double withdrawAmount = scanner.nextDouble();
                bank.withdraw(withdrawAmount);
            } else if (selection == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        scanner.close();
    }
}