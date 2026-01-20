public class StringTest {
    private String myText;

    public StringTest(String text) {
        myText = text;
    }

    public int getLength() {
        return myText.length();
    }

    public void printInfo() {
        System.out.println(myText);
        System.out.println("Length: " + getLength());
    }

    public void printChar(int index) {
        System.out.println(myText.charAt(index));
    }

    public void printLocation(String str) {
        System.out.println(myText.indexOf(str));
    }

    public int countChar(char c) {
        int count = 0;

        for (int i = 0; i < myText.length(); i++) {
            if (myText.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    public boolean contains(String str) {
        if (myText.indexOf(str) != -1) {
            return true;
        }
        return false;
    }

    public int countVowels() {
        int count = 0;

        for (int i = 0; i < myText.length(); i++) {
            char ch = myText.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }
}