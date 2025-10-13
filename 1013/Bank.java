class Bank {
    private String name;
    private double balance;

    public Bank(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void printName() {
        System.out.println("Account holder: " + name);
    }

    public void printBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Corrected method signatures to accept a parameter for the transaction amount
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrew $" + amount);
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}