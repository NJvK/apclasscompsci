import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Farm extends JPanel implements ActionListener {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int GROUND_Y = 400;

    private Timer timer = new Timer(30, this);

    private enum Phase { SUNRISE, DAY, NIGHT }
    private Phase phase = Phase.SUNRISE;
    private long startTime = System.currentTimeMillis();

    private int sunriseTime = 3000;
    private int dayTime = 8000;
    private int nightTime = 8000;

    private int sunR = 35;
    private int sunX = 100;
    private int sunY = GROUND_Y + 80;

    private int dogX = -100;
    private int birdX = WIDTH + 100;
    private int bunnyX = 200;
    private int dogSpeed = 2;
    private int birdSpeed = -3;
    private int bunnySpeed = 2;

    public Farm() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        updateSunAndPhase();
        updateAnimals();
        repaint();
    }

    private void updateSunAndPhase() {
        long t = System.currentTimeMillis() - startTime;

        if (phase == Phase.SUNRISE) {
            double p = Math.min(1.0, (double)t / sunriseTime);
            sunY = (int)(GROUND_Y + 80 - p * 200);
            if (t >= sunriseTime) {
                phase = Phase.DAY;
                startTime = System.currentTimeMillis();
                sunX = 100;
                sunY = 200;
            }
        } else if (phase == Phase.DAY) {
            sunX += 3;
            if (sunX > WIDTH + 100) {
                phase = Phase.NIGHT;
                startTime = System.currentTimeMillis();
            }
        } else if (phase == Phase.NIGHT) {
            if (t > nightTime) {
                phase = Phase.SUNRISE;
                startTime = System.currentTimeMillis();
                sunX = 100;
                sunY = GROUND_Y + 80;
            }
        }
    }

    private void updateAnimals() {
        boolean moving = (phase != Phase.NIGHT);

        if (moving) {
            dogX += dogSpeed;
            if (dogX > WIDTH + 80) dogX = -100;

            birdX += birdSpeed;
            if (birdX < -100) birdX = WIDTH + 100;

            bunnyX += bunnySpeed;
            if (bunnyX > WIDTH - 40 || bunnyX < 40) {
                bunnySpeed *= -1;
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // sky
        if (phase == Phase.NIGHT) {
            g.setColor(new Color(20, 30, 60));
        } else {
            g.setColor(new Color(135, 206, 235));
        }
        g.fillRect(0, 0, WIDTH, GROUND_Y);

        // ground
        g.setColor(new Color(90, 160, 90));
        g.fillRect(0, GROUND_Y, WIDTH, HEIGHT - GROUND_Y);

        // draw grass using a while loop
        g.setColor(new Color(20, 120, 20));
        int x = 0;
        while (x < WIDTH) {
            int y = GROUND_Y;
            int h = (int)(Math.random() * 10 + 5);
            g.drawLine(x, y, x, y - h);
            x += 5;
        }

        drawSun(g);
        drawDog(g, dogX, GROUND_Y - 30);
        drawBird(g, birdX, 150);
        drawBunny(g, bunnyX, GROUND_Y - 20);
    }

    private void drawSun(Graphics g) {
        if (phase == Phase.NIGHT) return;

        Graphics2D g2 = (Graphics2D) g;
        int cx = sunX;
        int cy = sunY;
        int r = sunR;

        g2.setColor(new Color(255, 205, 0));
        g2.fillOval(cx - r, cy - r, r * 2, r * 2);

        g2.setStroke(new BasicStroke(2f));
        int inner = r + 8;
        int outer = r + 22;

        g2.drawLine(cx - outer, cy, cx - inner, cy);
        g2.drawLine(cx + inner, cy, cx + outer, cy);
        g2.drawLine(cx, cy - outer, cx, cy - inner);
        g2.drawLine(cx, cy + inner, cx, cy + outer);
    }

    private void drawDog(Graphics g, int x, int y) {
        g.setColor(new Color(160, 110, 70));
        g.fillOval(x, y - 20, 60, 25);
        g.fillOval(x + 40, y - 30, 18, 18);
        g.setColor(Color.BLACK);
        g.fillOval(x + 52, y - 24, 4, 4);
    }

    private void drawBird(Graphics g, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x - 10, y - 5, 20, 10);
        g.setColor(Color.ORANGE);
        int[] bx = {x + 10, x + 16, x + 10};
        int[] by = {y, y + 3, y + 6};
        g.fillPolygon(bx, by, 3);
    }

    private void drawBunny(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x - 10, y - 10, 25, 18);
        g.fillOval(x + 8, y - 15, 10, 10);
        g.setColor(Color.PINK);
        g.fillOval(x + 10, y - 22, 5, 10);
        g.fillOval(x + 14, y - 22, 5, 10);
    }
}