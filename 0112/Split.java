public class Split {

    private String email;

    public Split(String e) {
        email = e;
    }

    public String getName() {
        int atIndex = email.indexOf("@");
        return email.substring(0, atIndex);
    }

    public String getDomain() {
        int atIndex = email.indexOf("@");
        int dotIndex = email.lastIndexOf(".");
        return email.substring(atIndex + 1, dotIndex);
    }

    public String getLastNameMVLA(String mvlaEmail) {
        int dotIndex = mvlaEmail.indexOf(".");
        int atIndex = mvlaEmail.indexOf("@");
        return mvlaEmail.substring(dotIndex + 1, atIndex);
    }

    public String toString() {
        return "address: " + email;
    }
}