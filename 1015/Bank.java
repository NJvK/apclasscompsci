public class Bank {
    private String name;
    private double balance;
    private int pin;
    private boolean access;

    public Bank(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        access = false;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public int pin() {
        return pin;
    }
    public boolean getAccess() {
        return access;
    }
    public void checkedPin(int pin) {
        if (pin == this.pin) {
            access = true;
            System.out.println("Access granted.");
        } else {
            access = false;
            System.out.println("Access denied.");
        }
    }
    public void deposit(double amount) {
        if (access) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } else {
            System.out.println("Access denied. Please check your PIN.");
        }
    }
    public void withdraw(double amount) {
        if (access) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Insufficient funds or invalid amount.");
            }
        } else {
            System.out.println("Access denied. Please check your PIN.");
        }
    }
    public void logout() {
        access = false;
        System.out.println("Logged out.");
    }
}
