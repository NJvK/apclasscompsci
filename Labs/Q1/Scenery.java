import javax.swing.*;
import java.awt.*;

/**
 * Scenery.java
 * Extends JPanel and handles all drawing logic for the Berlin Wall scene.
 * Uses only basic Graphics methods and if/else logic for APCS compatibility.
 * The Tree object now uses fillPolygon for the foliage.
 */
public class Scenery extends JPanel {

    private boolean isDay;
    private String weather;
    private int width = 1200;
    private int height = 700;
    private boolean lightState = false; // Kept here in case animation is re-added

    // Constructor to set up the instance variables
    public Scenery(boolean isDay, String weather) {
        this.isDay = isDay;
        this.weather = weather;
    }
    
    // Method required by APCS to set preferred dimensions
    @Override
    public Dimension getPreferredSize() {
        // Dimension is less than 1920x1080
        return new Dimension(width, height);
    }

    // Setter for the animation state (kept here in case animation is re-added)
    public void setLightState(boolean lightState) {
        this.lightState = lightState;
    }
    
    // --- Drawing Methods ---

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. Draw Background and Weather
        drawBackground(g);
        drawWeather(g);
        
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
        if (isDay) {
            g.setColor(new Color(135, 206, 235)); // Sky Blue
        } else {
            g.setColor(new Color(25, 25, 112));  // Midnight Blue
        }
        g.fillRect(0, 0, width, height);
        
        // Draw Ground (visible in all scenes)
        g.setColor(new Color(105, 105, 105)); // Gray/Asphalt
        g.fillRect(0, height - 150, width, 150);

        // Night specific elements (Stars/Moon)
        if (!isDay) {
            g.setColor(Color.WHITE);
            // Draw simple stars
            g.fillOval(50, 50, 4, 4);
            g.fillOval(150, 80, 3, 3);
            g.fillOval(400, 60, 5, 5);
            g.fillOval(650, 100, 2, 2);
            g.fillOval(850, 40, 4, 4);
        }
    }
    
    private void drawWeather(Graphics g) {
        if (weather.equals("Sunny")) {
            // Draw Sun (Daytime only)
            if (isDay) {
                g.setColor(Color.YELLOW);
                g.fillOval(50, 50, 80, 80);
            }
        } else if (weather.equals("Cloudy") || weather.equals("Rainy")) {
            // Draw Clouds (required for Cloudy/Rainy)
            g.setColor(Color.LIGHT_GRAY);
            // Simple overlapping ovals to form a cloud shape
            drawCloudShape(g, 100, 80);
            drawCloudShape(g, 500, 50);
            drawCloudShape(g, 850, 100);

            if (weather.equals("Rainy")) {
                // Draw Rain (blue lines)
                g.setColor(new Color(0, 191, 255, 150)); // Light Transparent Blue
                for (int i = 0; i < width; i += 10) {
                    for (int j = 0; j < height - 150; j += 15) {
                        g.drawLine(i, j, i + 5, j + 15);
                    }
                }
            }
        }
    }
    
    // Helper method for drawing clouds
    private void drawCloudShape(Graphics g, int x, int y) {
        g.fillOval(x, y, 60, 40);
        g.fillOval(x + 30, y - 10, 70, 50);
        g.fillOval(x + 60, y, 50, 35);
        g.fillOval(x + 10, y + 10, 80, 45);
    }
    
    // --- Landmark: The Berlin Wall (Complexity: simulated bricks/damage) ---
    private void drawBerlinWall(Graphics g) {
        int wallHeight = 400;
        int wallY = height - wallHeight;

        // Wall Base Color
        g.setColor(new Color(192, 192, 192)); // Silver/Light Gray
        g.fillRect(width / 2 - 300, wallY, 600, wallHeight - 150);

        // Rounded Top (simulated with a large rectangle slightly higher and curved top rectangle)
        g.setColor(new Color(128, 128, 128)); // Darker Gray
        g.fillRect(width / 2 - 300, wallY - 30, 600, 30);
        g.fillOval(width / 2 - 300, wallY - 50, 600, 40);
        
        // Simple Graffiti (Rectangles of color)
        g.setColor(new Color(255, 0, 127)); // Pink
        g.fillRect(width / 2 - 250, wallY + 50, 50, 150);
        g.setColor(new Color(0, 255, 0)); // Green
        g.fillRect(width / 2 + 100, wallY + 100, 100, 50);
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

        // Light Fixture (simple oval)
        if (!isDay && lightState) {
            g.setColor(Color.YELLOW); 
        } else if (isDay) {
            g.setColor(Color.GRAY); 
        } else {
            g.setColor(Color.BLACK); 
        }
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
