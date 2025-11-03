public class RunnerTest {
    public static void main(String[] args) {
        ForTest tester = new ForTest();

        tester.printCount();

        tester.printCount(25);

        tester.printCount(5, 20);

        int result = tester.getFactorial(5);
        System.out.println("Factorial of 5 = " + result);

        tester.drawBox();
    }
}
