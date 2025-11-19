public class ArrayRunner {
    public static void main(String[] args) {
        ArrayTest at = new ArrayTest(4);

        at.print();

        int sum = at.getSum();
        System.out.println("Sum: " + sum);

        int largest = at.getLargest();
        System.out.println("Largest: " + largest);
    }
}