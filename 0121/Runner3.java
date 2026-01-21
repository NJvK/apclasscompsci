import java.util.Random;

public class Runner3 {
    public static void main(String[] args) {

        String[] wordBank = {
                "apple", "zebra", "cloud", "river", "banana",
                "tiger", "school", "music", "coffee", "pizza"
        };

        Random rand = new Random();

        String[] words = new String[5];
        for (int i = 0; i < words.length; i++) {
            words[i] = wordBank[rand.nextInt(wordBank.length)];
        }

        ArrayTest3 at = new ArrayTest3();

        at.printArray(words);

        at.scramble(words);
        at.printArray(words);

        at.sort(words);
        at.printArray(words);
    }
}
