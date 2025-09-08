import java.util.Scanner;
public class WarmUp{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter in a noun");
        String noun = scan.nextLine();
        System.out.println("Enter in a verb");
        String verb = scan.nextLine();
        System.out.println("The " + noun + " " + verb + "s.");
    }
}