import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Farm extends JPanel implements ActionListener {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    private static final int GROUND_Y = 450;

    // Timer
    private final Timer timer = new Timer(16, this);
    private long phaseStartMs = System.currentTimeMillis();

    // Day/Night phases
    private enum Phase { SUNRISE, DAY, NIGHT }
    private Phase phase = Phase.SUNRISE;

    // Durations for sun
    private long sunriseDurationMs = 3000;
    private long dayDurationMs = 12000;
    private long nightDurationMs = dayDurationMs;

    // Sun
    private int sunR = 35;
    private double sunX = -100;
    private double sunY = 100;
    private double sunSpeed = 3.0;
    private double sunriseYStart = GROUND_Y + sunR + 10;
    private double sunriseYEnd = 120;
    private double sunriseX = 120;

    // Dog
    private double dogX = -120, dogY = GROUND_Y - 30;
    private double dogDX = 2.0;

    // Bird
    private double birdX = WIDTH + 100, birdY = 220;
    private double birdDX = -3.0;

    // Bunny
    private double bunnyX = 350, bunnyY = GROUND_Y - 22;
    private double bunnyDX = 2.5;

    private final Random rand = new Random();

    public Farm() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        resetToSunrise();
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        updateSunAndPhase();
        updateAnimals();
        repaint();
    }

    private void updateSunAndPhase() {
        long t = System.currentTimeMillis() - phaseStartMs;

        switch (phase) {
            case SUNRISE:
                if (t >= sunriseDurationMs) {
                    phase = Phase.DAY;
                    phaseStartMs = System.currentTimeMillis();
                    sunX = -sunR * 2;
                    sunY = sunriseYEnd;
                } else {
                    double p = t / (double) sunriseDurationMs;
                    sunX = sunriseX;
                    sunY = lerp(sunriseYStart, sunriseYEnd, p);
                }
                break;

            case DAY:
                sunX += sunSpeed;
                if (sunX > WIDTH + sunR * 2) {
                    phase = Phase.NIGHT;
                    phaseStartMs = System.currentTimeMillis();
                }
                break;

            case NIGHT:
                if (t >= nightDurationMs) {
                    resetToSunrise();
                }
                break;
        }
    }

    private void updateAnimals() {
        boolean moving = (phase != Phase.NIGHT);

        if (moving) {
            dogX += dogDX;
            if (dogX > WIDTH + 80) dogX = -120;

            birdX += birdDX;
            if (birdX < -100) birdX = WIDTH + 120;

            bunnyX += bunnyDX;
            if (bunnyX < 40) { bunnyX = 40; bunnyDX = Math.abs(bunnyDX); }
            if (bunnyX > WIDTH - 40) { bunnyX = WIDTH - 40; bunnyDX = -Math.abs(bunnyDX); }
        }
    }

    private void resetToSunrise() {
        phase = Phase.SUNRISE;
        phaseStartMs = System.currentTimeMillis();
        sunX = sunriseX;
        sunY = sunriseYStart;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sky
        if (phase == Phase.NIGHT) {
            g.setColor(new Color(10, 20, 45));
            g.fillRect(0, 0, WIDTH, GROUND_Y);
            drawStars(g);
        } else {
            g.setColor(new Color(135, 206, 235));
            g.fillRect(0, 0, WIDTH, GROUND_Y);
        }

        // Ground
        g.setColor(new Color(95, 170, 95));
        g.fillRect(0, GROUND_Y, WIDTH, HEIGHT - GROUND_Y);

        // Grass
        drawGrassField(g);

        // Sun
        drawSun(g);

        // Trees
        int treeRows = 5, treeCols = 5;
        int treeStartX = 600, treeStartY = 480, treeDX = 110, treeDY = 60;
        for (int r = 0; r < treeRows; r++) {
            for (int c = 0; c < treeCols; c++) {
                int x = treeStartX + c * treeDX;
                int y = treeStartY + r * treeDY;
                drawFruitTree(g, x, y);
            }
        }

        // Carrots
        int vegRows = 5, vegCols = 5;
        int vegStartX = 150, vegStartY = 500, vegDX = 60, vegDY = 30;
        for (int r = 0; r < vegRows; r++) {
            for (int c = 0; c < vegCols; c++) {
                int x = vegStartX + c * vegDX;
                int y = vegStartY + r * vegDY;
                drawCarrot(g, x, y);
            }
        }

        // Animals that stop at night
        drawDog(g, (int) dogX, (int) dogY);
        drawBird(g, (int) birdX, (int) birdY);
        drawBunny(g, (int) bunnyX, (int) bunnyY);
    }
    // draws sun
    private void drawSun(Graphics g) {
        if (phase == Phase.NIGHT) return;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(255, 205, 0));
        g2.fillOval((int) sunX - sunR, (int) sunY - sunR, sunR * 2, sunR * 2);
        g2.setStroke(new BasicStroke(2f));
        for (int i = 0; i < 12; i++) {
            double a = Math.toRadians(i * 30);
            int x1 = (int) (sunX + Math.cos(a) * (sunR + 8));
            int y1 = (int) (sunY + Math.sin(a) * (sunR + 8));
            int x2 = (int) (sunX + Math.cos(a) * (sunR + 22));
            int y2 = (int) (sunY + Math.sin(a) * (sunR + 22));
            g2.drawLine(x1, y1, x2, y2);
        }
    }
    // draws stars
    private void drawStars(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < 120; i++) {
            int x = rand.nextInt(WIDTH);
            int y = rand.nextInt(Math.max(1, GROUND_Y - 20));
            g.fillRect(x, y, 2, 2);
        }
        g.setColor(new Color(230, 230, 255));
        g.fillOval(980, 80, 28, 28);
    }
    // draws grass
    private void drawGrassField(Graphics g) {
        for (int y = GROUND_Y + 5; y < HEIGHT; y += 5) {
            for (int x = 0; x < WIDTH; x += 5) {
                int h = 5 + rand.nextInt(7);
                int shade = 90 + rand.nextInt(90);
                g.setColor(new Color(20, shade, 20));
                g.drawLine(x, y, x, y - h);
            }
        }
    }
    // draws fruit tree
    private void drawFruitTree(Graphics g, int x, int y) {
        g.setColor(new Color(110, 70, 40));
        g.fillRect(x - 5, y - 25, 10, 25);
        g.setColor(new Color(34, 139, 34));
        g.fillOval(x - 25, y - 60, 50, 28);
        g.fillOval(x - 35, y - 48, 50, 28);
        g.fillOval(x - 5,  y - 48, 50, 28);
        g.setColor(new Color(210, 0, 0));
        g.fillOval(x - 10, y - 50, 7, 7);
        g.fillOval(x + 8,  y - 44, 7, 7);
        g.fillOval(x - 20, y - 40, 7, 7);
    }
    // draws carrot
    private void drawCarrot(Graphics g, int x, int y) {
        g.setColor(new Color(20, 120, 50));
        g.fillOval(x - 6, y - 18, 12, 6);
        g.fillOval(x - 10, y - 14, 12, 6);
        g.fillOval(x + 0,  y - 14, 12, 6);
        g.setColor(new Color(255, 140, 0));
        int[] xs = { x, x - 8, x + 8 };
        int[] ys = { y - 12, y + 10, y + 10 };
        g.fillPolygon(xs, ys, 3);
    }

    // draws dog
    private void drawDog(Graphics g, int x, int y) {
        g.setColor(new Color(160, 110, 70));
        g.fillOval(x, y - 20, 70, 26);
        g.fillOval(x + 50, y - 28, 20, 20);
        g.setColor(Color.BLACK);
        g.fillOval(x + 62, y - 22, 4, 4);
        g.setColor(new Color(120, 80, 50));
        g.fillRect(x + 12, y + 3, 6, 12);
        g.fillRect(x + 42, y + 3, 6, 12);
        g.setColor(new Color(110, 70, 40));
        g.drawLine(x - 6, y - 10, x + 6, y - 16);
    }

    // draws bird
    private void drawBird(Graphics g, int x, int y) {
        g.setColor(new Color(220, 220, 230));
        g.fillOval(x - 16, y - 8, 32, 16);
        g.setColor(new Color(240, 180, 0));
        g.fillPolygon(new int[]{x + 16, x + 26, x + 16}, new int[]{y - 1, y + 3, y + 6}, 3);
        g.setColor(new Color(200, 200, 210));
        g.fillPolygon(new int[]{x - 5, x - 22, x - 2}, new int[]{y - 8, y - 22, y - 6}, 3);
        g.setColor(Color.BLACK);
        g.fillOval(x + 8, y - 3, 3, 3);
    }

    // draws bunny
    private void drawBunny(Graphics g, int x, int y) {
        g.setColor(new Color(230, 230, 240));
        g.fillOval(x - 16, y - 14, 30, 20);
        g.fillOval(x + 8, y - 18, 14, 14);
        g.setColor(new Color(255, 190, 210));
        g.fillOval(x + 12, y - 26, 6, 14);
        g.fillOval(x + 18, y - 26, 6, 14);
        g.setColor(Color.BLACK);
        g.fillOval(x + 16, y - 14, 3, 3);
    }

    private static double lerp(double a, double b, double p) {
        if (p < 0) p = 0;
        if (p > 1) p = 1;
        return a + (b - a) * p;
    }
}