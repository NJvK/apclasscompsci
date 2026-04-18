public class Runner3 {
    public static void main(String[] args) {
        Test t = new Test();

        t.printList();

        int largest = t.searchLargest();
        System.out.println("Largest: " + largest);
        System.out.println();

        t.searchAndReplace(5);
        t.printList();

        t.searchAndRemove(2);
        t.printList();

        t.sort();
        t.printList();
    }
}