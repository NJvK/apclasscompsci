public class Runner {
    public static void main(String[] args) {
        ArrayTest at = new ArrayTest(5);

        at.printArray();

        at.scramble();
        at.printArray();

        int result = at.search(0);
        System.out.println(result);

        at.sort();
        at.printArray();
    }
}