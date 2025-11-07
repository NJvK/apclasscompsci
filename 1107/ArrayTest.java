import java.util.Random;

/**
 * Contains various methods to demonstrate array creation, assignment, and printing.
 */
public class ArrayTest {

    // Helper method to generate a random number from min to max inclusive.
    private int getRandomNum(int min, int max) {
        // Formula: (int)(Math.random() * (max - min + 1) + min)
        return (int)(Math.random() * (max - min + 1) + min);
    }

    public void arrayDemo1() {
        System.out.println("--- Demo 1 ---");
        System.out.println("Printing array of size 5 (The long way)");

        int[] numbers = new int[5];

        numbers[0] = getRandomNum(1, 15);
        numbers[1] = getRandomNum(1, 15);
        numbers[2] = getRandomNum(1, 15);
        numbers[3] = getRandomNum(1, 15);
        numbers[4] = getRandomNum(1, 15);

        System.out.println("Index 0: " + numbers[0]);
        System.out.println("Index 1: " + numbers[1]);
        System.out.println("Index 2: " + numbers[2]);
        System.out.println("Index 3: " + numbers[3]);
        System.out.println("Index 4: " + numbers[4]);
    }

    public void arrayDemo2() {
        System.out.println("\n--- Demo 2 ---");
        System.out.println("Printing array of size 25 (Two loops)");

        int[] largeArray = new int[25];

        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = getRandomNum(1, 9);
        }
        System.out.print("Array Contents: [");
        for (int i = 0; i < largeArray.length; i++) {
            System.out.print(largeArray[i]);
            if (i < largeArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public void arrayDemo3() {
        System.out.println("\n--- Demo 3 ---");
        System.out.println("Printing String array of size 5");

        String[] words = new String[5];
        words[0] = "Apple";
        words[1] = "Banana";
        words[2] = "Cherry";
        words[3] = "Date";
        words[4] = "Elderberry";

        System.out.print("Array Contents: [");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i < words.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void arrayDemo4() {
        System.out.println("\n--- Demo 4 ---");
        System.out.println("Printing Profile array of size 5");

        Profile[] profiles = new Profile[5];

        profiles[0] = new Profile("Alice");
        profiles[1] = new Profile("Bob");
        profiles[2] = new Profile("Charlie");
        profiles[3] = new Profile("Diana");
        profiles[4] = new Profile("Eve");

        for (int i = 0; i < profiles.length; i++) {
            System.out.println("Profile " + i + ": " + profiles[i].getName());
        }
    }
}
