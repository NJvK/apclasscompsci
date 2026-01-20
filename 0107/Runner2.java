public class Runner2 {
    public static void main(String[] args) {
        StringTest test = new StringTest("The quick brown fox jumps over the lazy dog");

        test.printInfo();

        test.printChar(0);
        test.printChar(5);
        test.printChar(10);
        test.printChar(15);

        test.printLocation("h");
        test.printLocation("e");
        test.printLocation("jumps");
        test.printLocation("dog");

        int oCount = test.countChar('o');
        System.out.println(oCount);

        System.out.println(test.contains("dog"));
        System.out.println(test.contains("java"));

        System.out.println(test.countVowels());
    }
}