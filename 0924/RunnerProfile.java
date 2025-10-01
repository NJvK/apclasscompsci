public class RunnerProfile {
    public static void main(String[] args) {
        Profile profile1 = new Profile();
        profile1.printInfo();
        profile1.printInfo(1234);
        Profile profile2 = new Profile("Jennifer ", 16);
        profile2.printInfo();
        profile2.printInfo(4321);
    }
}
