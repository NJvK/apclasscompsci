public class Runner {
    public static void main(String[] args) {
        Profile profile1 = new Profile();
        Profile profile2 = new Profile("David", 16);
        System.out.println("Profile 1:");
        profile1.printName();
        profile1.printAge();
        System.out.println("Profile 2:");
        profile2.printName();
        profile2.printAge();
    }
}
