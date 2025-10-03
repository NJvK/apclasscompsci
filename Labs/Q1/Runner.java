package Q1;
import javax.swing.JFrame;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Daytime\n2. Nighttime");
        int timeChoice = scanner.nextInt();
        if (timeChoice == 1) {
            System.out.println("1. Clear Sky\n2. Cloudy Sky\n3. Rainy Sky");
            scanner = new Scanner(System.in);
            int weatherChoice = scanner.nextInt();
            if (weatherChoice == 1) {
                Scenery scenery = new Scenery();
                scenery.choice = 1;
                JFrame jFrame = new JFrame("Q1");
                jFrame.setSize(500, 500);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(scenery);
                jFrame.repaint();
                jFrame.pack();
            } else if (weatherChoice == 2) {
                Scenery2 scenery = new Scenery2();
                scenery.choice = 2;
                JFrame jFrame = new JFrame("Q1");
                jFrame.setSize(500, 500);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(scenery);
                jFrame.repaint();
                jFrame.pack();
            } else if (weatherChoice == 3) {
                Scenery3 scenery = new Scenery3();
                scenery.choice = 3;
                JFrame jFrame = new JFrame("Q1");
                jFrame.setSize(500, 500);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(scenery);
                jFrame.repaint();
                jFrame.pack();
            } else {
                System.out.println("Invalid choice. Defaulting to Clear Sky.");
            }
        } else if (timeChoice == 2) {
            System.out.println("1. Clear Sky\n2. Cloudy Sky\n3. Rainy Sky");
            scanner = new Scanner(System.in);
            int weatherChoice = scanner.nextInt();
            if (weatherChoice == 1) {
                Scenery2 scenery = new Scenery2();
                scenery.choice = 1;
                JFrame jFrame = new JFrame("Q1");
                jFrame.setSize(500, 500);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(scenery);
                jFrame.repaint();
                jFrame.pack();
            } else if (weatherChoice == 2) {
                Scenery4 scenery = new Scenery4();
                scenery.choice = 2;
                JFrame jFrame = new JFrame("Q1");
                jFrame.setSize(500, 500);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(scenery);
                jFrame.repaint();
                jFrame.pack();
            } else if (weatherChoice == 3) {
                Scenery4 scenery = new Scenery4();
                scenery.choice = 3;
                JFrame jFrame = new JFrame("Q1");
                jFrame.setSize(500, 500);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.add(scenery);
                jFrame.repaint();
                jFrame.pack();
            } else {
                System.out.println("Invalid choice. Defaulting to Clear Sky.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
