public class Bank{
    private String name;
    private double balance;
    public Bank(String name, double balance){
  	    name = this.name;
        balance = this.getBalance();
    }
    public String getName(){
  	    return name;
    }
    public double getBalance(){
        return balance;
    }
    public void withdraw(double amount){
        if (amount < 0){
            deposit(amount);
        } else {
            balance -= amount;
        System.out.println("Your account total is: $" + balance);
        }
    }
    public void deposit(double amount){
        if (amount < 0){
            withdraw(amount);
        } else {
            balance += amount;
        System.out.println("Your account total is: $" + balance);
        }
    }
}