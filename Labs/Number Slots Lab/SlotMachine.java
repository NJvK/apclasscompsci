import java.util.Random;

public class SlotMachine {
    private final Random rand = new Random();

    private int num1;
    private int num2;
    private int num3;

    private int winnings;
    private int balance;

    public SlotMachine(int startingBalance) {
        balance = Math.max(0, startingBalance);
        winnings = 0;
        num1 = num2 = num3 = 0;
    }

    public void play() {
        if (balance <= 0) {
            winnings = 0;
            return;
        }
        balance -= 1;

        num1 = rand.nextInt(9) + 1;
        num2 = rand.nextInt(9) + 1;
        num3 = rand.nextInt(9) + 1;

        winnings = computeWinnings(num1, num2, num3);
        balance += winnings;
    }

    private int computeWinnings(int a, int b, int c) {
        if (a == 7 && b == 7 && c == 7) return 100;
        if (a == b && b == c) return 5;
        if (a == b || a == c || b == c) return 1;
        return 0;
    }

    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public int getNum3() { return num3; }
    public int getWinnings() { return winnings; }
    public int getBalance() { return balance; }
    public boolean canSpin() { return balance > 0; }
}
