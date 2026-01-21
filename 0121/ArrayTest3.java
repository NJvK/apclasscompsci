import java.util.Random;

public class ArrayTest3 {

    public void printArray(String[] arr) {
        for (String word : arr) {
            System.out.println(word);
        }
        System.out.println();
    }

    public void scramble(String[] arr) {
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randomIndex = rand.nextInt(arr.length);

            String temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    public void sort(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
    }
}