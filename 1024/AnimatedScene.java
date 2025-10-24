import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class AnimatedScene extends JPanel implements ActionListener {
    private static final int WIDTH = 800, HEIGHT = 500, GROUND_Y = 380;
    private Timer timer = new Timer(20, this);
    private ArrayList<Point> trees = new ArrayList<>();
    private ArrayList<Point> grass = new ArrayList<>();
    private Random rand = new Random();

    private double cloudX = 50, cloudY = 80;
    private double sunX = 50, sunY = 70;
    private double animalX = 0;
    private double balloonX = 700, balloonY = 350;
    private double planeX = WIDTH;

    public AnimatedScene() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(135, 206, 235));

        int t = 0, tx = 20;
        while (t < 20) {
            trees.add(new Point(tx, GROUND_Y));
            tx += 40;
            t++;
        }

        int g = 0;
        do {
            grass.add(new Point(rand.nextInt(WIDTH), GROUND_Y + rand.nextInt(50)));
            g++;
        } while (g < 100);

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        cloudX += 1.5;
        if (cloudX > WIDTH + 60) cloudX = -100;

        sunX += 1;
        if (sunX > WIDTH + 40) sunX = -60;

        animalX += 2;
        if (animalX > WIDTH + 60) animalX = -100;

        balloonX += 1;
        balloonY -= 0.5;
        if (balloonX > WIDTH + 60) balloonX = -60;
        if (balloonY < -80) balloonY = HEIGHT;

        planeX -= 3;
        if (planeX < -120) planeX = WIDTH + 100;

        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(34, 139, 34));
        g2.fillRect(0, GROUND_Y, WIDTH, HEIGHT - GROUND_Y);

        g2.setColor(new Color(46, 139, 87));
        for (Point p : grass) g2.fillRect(p.x, p.y, 2, 8);

        for (Point t : trees) {
            g2.setColor(new Color(101, 67, 33));
            g2.fillRect(t.x, t.y - 30, 10, 30);
            g2.setColor(new Color(0, 100, 0));
            g2.fillOval(t.x - 15, t.y - 55, 40, 30);
        }

        g2.setColor(Color.WHITE);
        g2.fillOval((int) cloudX, (int) cloudY, 60, 35);
        g2.fillOval((int) cloudX + 25, (int) cloudY - 10, 50, 35);

        g2.setColor(Color.YELLOW);
        g2.fillOval((int) sunX, (int) sunY, 50, 50);

        int ax = (int) animalX, ay = GROUND_Y - 25;
        g2.setColor(new Color(160, 110, 70));
        g2.fillOval(ax, ay, 60, 25);
        g2.fillOval(ax + 45, ay - 10, 20, 20);
        g2.setColor(Color.BLACK);
        g2.fillOval(ax + 58, ay - 4, 5, 5);
        g2.setColor(new Color(120, 80, 50));
        g2.fillRect(ax + 10, ay + 20, 6, 10);
        g2.fillRect(ax + 40, ay + 20, 6, 10);

        int bx = (int) balloonX, by = (int) balloonY;
        g2.setColor(Color.RED);
        g2.fillOval(bx - 25, by - 60, 50, 60);
        g2.setColor(new Color(150, 100, 60));
        g2.fillRect(bx - 10, by, 20, 15);
        g2.setColor(new Color(120, 70, 40));
        g2.drawLine(bx - 10, by, bx - 15, by - 10);
        g2.drawLine(bx + 10, by, bx + 15, by - 10);

        int px = (int) planeX, py = 100;
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRoundRect(px - 40, py - 10, 80, 20, 10, 10);
        g2.setColor(Color.DARK_GRAY);
        Polygon wing = new Polygon();
        wing.addPoint(px - 10, py - 5);
        wing.addPoint(px - 40, py - 20);
        wing.addPoint(px, py - 5);
        g2.fillPolygon(wing);
        g2.setColor(Color.CYAN);
        g2.fillOval(px + 15, py - 5, 10, 10);
    }
}
