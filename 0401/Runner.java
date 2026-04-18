public class Runner {
    public static void main(String[] args) {

        MyMath math = new MyMath();

        math.countDown(5);
        System.out.println();

        math.countUp(10);
        System.out.println();

        int fact = math.factorial(5);
        System.out.println("Factorial: " + fact);

        int sum = math.summation(5);
        System.out.println("Summation: " + sum);
    }
}