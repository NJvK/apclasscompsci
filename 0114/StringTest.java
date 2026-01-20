public class StringTest {

    private String email;

    public StringTest(String e) {
        email = e;
    }

    public int countChar(char c) {
        int count = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    public String getDomain() {
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");
        return email.substring(atIndex + 1, dotIndex);
    }

    public String toString() {
        return email + " " + email.length();
    }
}