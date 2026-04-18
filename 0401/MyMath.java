public class MyMath {

    // counts down from n to 0
    public void countDown(int n) {
        if (n < 0) {
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }

    // counts up from 1 to n
    public void countUp(int n) {
        countUpHelper(1, n);
    }

    // helper method to handle recursion properly
    private void countUpHelper(int current, int n) {
        if (current > n) {
            return;
        }
        System.out.println(current);
        countUpHelper(current + 1, n);
    }

    // factorial of n
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // summation from n down to 1
    public int summation(int n) {
        if (n == 1) {
            return 1;
        }
        return n + summation(n - 1);
    }
}