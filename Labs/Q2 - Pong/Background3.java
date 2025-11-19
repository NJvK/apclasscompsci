import java.awt.*;
import javax.swing.*;

public class Background3 extends JPanel {    
    // Method required by APCS to set preferred dimensions
    @Override
    public Dimension getPreferredSize() {
        // Dimension is less than 1920x1080
        return new Dimension(1200, 700);
    }

    // --- Drawing Methods ---

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. Draw Background and Weather
        drawBackground(g);
        
        // 2. Draw Foreground Objects
        // Draw the main landmark once
        drawBerlinWall(g);

        // Draw the four non-landmark objects multiple times
        drawTree(g, 100, 450);
        drawTree(g, 950, 480);

        drawStreetLamp(g, 300, 300);
        drawStreetLamp(g, 750, 320);

        drawParkBench(g, 400, 500);
        drawParkBench(g, 650, 520);
        
        drawPerson(g, 550, 500);
        drawPerson(g, 200, 550);
    }

    private void drawBackground(Graphics g) {
        // Light Blue for Day, Dark Blue for Night
        g.setColor(new Color(135, 206, 235)); // Sky Blue
        g.fillRect(0, 0, 1200, 700);
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 80, 80);
        
        // Draw Ground (visible in all scenes)
        g.setColor(new Color(105, 105, 105)); // Gray/Asphalt
        g.fillRect(0, 700 - 150, 1200, 150);
    }
    
    // --- Landmark: The Berlin Wall (Complexity: simulated bricks/damage) ---
    private void drawBerlinWall(Graphics g) {
        int wall700 = 400;
        int wallY = 700 - wall700;

        // Wall Base Color
        g.setColor(new Color(192, 192, 192)); // Silver/Light Gray
        g.fillRect(1200 / 2 - 300, wallY, 600, wall700 - 150);

        // Rounded Top (simulated with a large rectangle slightly higher and curved top rectangle)
        g.setColor(new Color(128, 128, 128)); // Darker Gray
        g.fillRect(1200 / 2 - 300, wallY - 30, 600, 30);
        g.fillOval(1200 / 2 - 300, wallY - 50, 600, 40);
        
        // Simple Graffiti (Rectangles of color)
        g.setColor(new Color(255, 0, 127)); // Pink
        g.fillRect(1200 / 2 - 250, wallY + 50, 50, 150);
        g.setColor(new Color(0, 255, 0)); // Green
        g.fillRect(1200 / 2 + 100, wallY + 100, 100, 50);
    }

    // --- Foreground Object 1: Tree (Complexity: Trunk and Foliage using fillPolygon) ---
    private void drawTree(Graphics g, int x, int y) {
        int trunkW = 30;
        int trunkH = 100;
        
        // Trunk (Brown rectangle)
        g.setColor(new Color(139, 69, 19)); 
        g.fillRect(x, y, trunkW, trunkH);
        
        // Foliage (Green triangle using fillPolygon)
        g.setColor(new Color(34, 139, 34)); 
        
        // Define the 3 x-coordinates for the triangle
        int[] xPoints = {
            x + (trunkW / 2), // Top center point
            x - 40,           // Bottom left point
            x + trunkW + 40   // Bottom right point
        };
        
        // Define the 3 y-coordinates for the triangle
        int[] yPoints = {
            y - 50,     // Top center point (highest point)
            y + 50,     // Bottom two points (base of the triangle)
            y + 50      
        };
        
        // Draw the triangle with fillPolygon
        g.fillPolygon(xPoints, yPoints, 3);
    }

    // --- Foreground Object 2: Street Lamp (Complexity: Pole, Fixture) ---
    private void drawStreetLamp(Graphics g, int x, int y) {
        int poleW = 10;
        int poleH = 200;

        // Pole (Dark Gray)
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, poleW, poleH);

        // Arm (Small rectangle)
        g.fillRect(x + poleW, y, 50, 5);

        g.fillOval(x + poleW + 50, y - 10, 20, 20);
    }
    
    // --- Foreground Object 3: Person Silhouette (Complexity: multiple shapes) ---
    private void drawPerson(Graphics g, int x, int y) {
        // Simple dark silhouette
        g.setColor(Color.BLACK);
        
        // Head
        g.fillOval(x, y, 20, 20);
        
        // Body
        g.fillRect(x + 5, y + 20, 10, 40);
        
        // Legs (simple narrow rectangles)
        g.fillRect(x + 5, y + 60, 5, 30);
        g.fillRect(x + 10, y + 60, 5, 30);
    }

    // --- Foreground Object 4: Park Bench (Complexity: Legs, Seat, Backrest) ---
    private void drawParkBench(Graphics g, int x, int y) {
        g.setColor(new Color(101, 67, 33)); // Wood Brown
        
        // Seat
        g.fillRect(x, y + 50, 100, 10);
        
        // Backrest
        g.fillRect(x, y + 10, 100, 10);
        
        // Legs (2 front, 2 back simulated)
        g.fillRect(x + 5, y + 60, 5, 20);
        g.fillRect(x + 90, y + 60, 5, 20);
    }
}