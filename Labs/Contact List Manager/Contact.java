public class Contact {
    private String firstName;
    private String lastName;
    private String email;

    public Contact(String first, String last, String email) {
        firstName = first;
        lastName = last;
        this.email = email;
    }

    public String toString() {
        return firstName + " " + lastName + " - " + email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailUsername() {
        int at = email.indexOf("@");
        if (at == -1) {
            return "";
        }
        return email.substring(0, at);
    }

    public String getEmailDomainName() {
        int at = email.indexOf("@");
        int dot = email.indexOf(".", at + 1);

        if (at == -1 || dot == -1) {
            return "";
        }
        return email.substring(at + 1, dot);
    }

    public String getEmailDomainExtension() {
        int dot = email.lastIndexOf(".");
        if (dot == -1 || dot == email.length() - 1) {
            return "";
        }
        return email.substring(dot + 1);
    }
}