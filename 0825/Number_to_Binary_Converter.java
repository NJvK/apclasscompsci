import java.util.Scanner;

public class Number_to_Binary_Converter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number to convert to binary: ");
        int number = scan.nextInt();
        
        // Convert the number to a binary string using the built-in method.
        String binaryString = Integer.toBinaryString(number);
        
        System.out.println("The binary representation is: " + binaryString);
        
        scan.close();
    }
    
}
