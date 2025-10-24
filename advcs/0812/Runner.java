import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Dog", "Buddy", 3);
        System.out.println(animal1.toString());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal type: ");
        String type = scanner.nextLine();
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal age: ");
        int age = scanner.nextInt();

        Animal animal = new Animal(type, name, age);
        System.out.println(animal.toString());
    }
}
