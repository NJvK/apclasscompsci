public class Runner {
    public static void main(String[] args) {
        Profile profile0 = new Profile();

        System.out.println("------------------------");

        Profile profile1 = new Profile("Alice", 20, "Math", "Reading", "Pizza");

        System.out.println("------------------------");

        Profile profile2 = new Profile("Bob", 25, "Science", "Hiking", "Sushi");

        System.out.println("------------------------");

        Profile profile3 = new Profile("Charlie", 16, "History", "Gaming", "Burgers");

        while (true) {
            System.out.println("-----------------------\n");
            System.out.println("Create your own profile:");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter name (or 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter favorite subject: ");
            scanner.nextLine();
            String subject = scanner.nextLine();
            System.out.print("Enter hobby: ");
            String hobby = scanner.nextLine();
            System.out.print("Enter favorite food: ");
            String food = scanner.nextLine();
            Profile profile4 = new Profile(name, age, subject, hobby, food);
            System.out.println();
        }
    }
}
