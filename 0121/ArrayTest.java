public class ArrayTest {

    private String[] words;

    public ArrayTest() {
        words = new String[] {"dog", "cat", "horse", "lion", "tiger"};
    }

    public void printWords() {
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();
    }

    public void swapWords(int index1, int index2) {
        String temp = words[index1];
        words[index1] = words[index2];
        words[index2] = temp;
    }
}
