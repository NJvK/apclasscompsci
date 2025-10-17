import java.util.Scanner;
public class Hello {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ener in your first name");
        String name = scan.nextLine();
        System.out.println("Hello " + name);
    }
}
