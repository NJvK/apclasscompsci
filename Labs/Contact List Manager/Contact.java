public class Contact {
    private String firstName;
    private String lastName;
    private String email;

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getUsername() {
        int atIndex = email.indexOf('@');
        if (atIndex == -1) {
            return "";
        }
        return email.substring(0, atIndex);
    }

    public String getDomainName() {
        int atIndex = email.indexOf('@');
        int dotIndex = email.indexOf('.', atIndex + 1);

        if (atIndex == -1 || dotIndex == -1) {
            return "";
        }
        return email.substring(atIndex + 1, dotIndex);
    }

    public String getDomainExtension() {
        int dotIndex = email.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == email.length() - 1) {
            return "";
        }
        return email.substring(dotIndex + 1);
    }
}