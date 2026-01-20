public class StringReview {

    public char getChar(String text, int index) {
        return text.charAt(index);
    }

    public int countChar(String text, char c) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }
}