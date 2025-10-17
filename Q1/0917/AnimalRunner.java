import java.util.Scanner;
public class AnimalRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Animal myAnimal = new Animal();
        System.out.print("Enter in an animal type ");
        String animal = scan.nextLine();
        System.out.print("Enter the age for the animal ");
        int age = scan.nextInt();
        myAnimal.setVariables(animal, age);
        myAnimal.info();
        scan.close();
    }
}
