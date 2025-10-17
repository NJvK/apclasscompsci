import javax.swing.*;
import java.util.Scanner;

/**
 * Runner.java
 * Handles user input using while(true) loops, initializes the JFrame, 
 * and instantiates Scenery. The animation has been removed.
 */
public class Runner {

    public static void main(String[] args) {
        
        // --- 1. Get User Inputs (Variables declared without 'final') ---
        Scanner scanner = new Scanner(System.in);
        boolean isDay = true; 
        String weather = "Sunny";

        // --- Day or Night input loop using while(true) ---
        System.out.println("--- Scenery Setup ---");
        while (true) {
            System.out.println("Select Background:");
            System.out.println("1. Day (Light Blue)");
            System.out.println("2. Night (Dark Blue)");
            System.out.print("Enter choice (1 or 2): ");
            
            if (scanner.hasNextInt()) {
                int bgChoice = scanner.nextInt();
                if (bgChoice == 1) {
                    isDay = true;
                    break; // Exit loop on valid choice
                } else if (bgChoice == 2) {
                    isDay = false;
                    break; // Exit loop on valid choice
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next(); // Consume invalid input to prevent infinite loop
            }
        }

        // --- Weather input loop using while(true) ---
        while (true) {
            System.out.println("\nSelect Weather:");
            System.out.println("1. Sunny");
            System.out.println("2. Cloudy");
            System.out.println("3. Rainy");
            System.out.print("Enter choice (1, 2, or 3): ");

            if (scanner.hasNextInt()) {
                int weatherChoice = scanner.nextInt();
                
                // Using if/else if structure for APCS compatibility
                if (weatherChoice == 1) {
                    weather = "Sunny";
                    break; // Exit loop on valid choice
                } else if (weatherChoice == 2) {
                    weather = "Cloudy";
                    break; // Exit loop on valid choice
                } else if (weatherChoice == 3) {
                    weather = "Rainy";
                    break; // Exit loop on valid choice
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.next(); // Consume invalid input to prevent infinite loop
            }
        }
        
        // Close scanner
        scanner.close();
        
        // --- 2. Instantiate Scenery and 3. Add to JFrame ---
        Scenery sceneryPanel = new Scenery(isDay, weather);

        // Use the selected variables in the title
        JFrame frame = new JFrame("Berlin Wall Scenery - " + (isDay ? "Day" : "Night") + ", " + weather);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(sceneryPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);

        // Animation section (Step 4) has been removed.
    }
}
