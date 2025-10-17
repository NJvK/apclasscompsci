import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter animal type: ");
        String type = scanner.nextLine();
        System.out.print("Enter animal age: ");
        int age = scanner.nextInt();
        Animal animal = new Animal(type, age);
        animal.animalInfo();
        scanner.close();
    }
}
