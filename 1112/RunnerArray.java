public class RunnerArray {
    public static void main(String[] args) {
        ArrayTest arr = new ArrayTest(10);

        arr.print();

        boolean found5 = arr.search(5);
        System.out.println("Does the array contain 5? " + found5);

        boolean found9 = arr.search(9);
        System.out.println("Does the array contain 9? " + found9);
    }
}