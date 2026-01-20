package bank;

public class Account {
    private int pin;
    protected double balance;
    protected String name;

    public Account(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public String toString() {
        return name + " has a balance of $" + balance;
    }
}