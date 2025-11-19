import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Screen extends JPanel {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    public static final int GROUND_Y = 380;

    private static final int LAKE_X = WIDTH - 300;
    private static final int LAKE_Y = GROUND_Y + 30;
    private static final int LAKE_W = 240;
    private static final int LAKE_H = 110;

    private final Random rand = new Random();
    private Tree[] myTrees;
    private Cloud[] clouds;
    private Grass[] grasses;

    private Dog dog;
    private Bird[] birds;
    private Fish[] fish;

    public Screen() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        myTrees = new Tree[100];
        for (int i = 0; i < myTrees.length; i++) {
            int rx = rand.nextInt(WIDTH - 40) + 20;
            int ry = GROUND_Y + rand.nextInt(HEIGHT - GROUND_Y - 20) + 20;
            myTrees[i] = new Tree(rx, ry);
        }

        clouds = new Cloud[20];
        for (int i = 0; i < clouds.length; i++) {
            int w = 50 + rand.nextInt(50);
            int h = 24 + rand.nextInt(16);
            int rx = rand.nextInt(WIDTH + w) - w;
            int ry = 40 + rand.nextInt(GROUND_Y - 120);
            clouds[i] = new Cloud(rx, ry, w, h, WIDTH);
        }

        grasses = new Grass[120];
        for (int i = 0; i < grasses.length; i++) {
            int rx = rand.nextInt(WIDTH);
            int ry = GROUND_Y + 5 + rand.nextInt(HEIGHT - GROUND_Y - 10);
            int gh = 6 + rand.nextInt(10);
            grasses[i] = new Grass(rx, ry, gh);
        }

        dog = new Dog(rand.nextInt(WIDTH - 80) + 40, GROUND_Y - 16);
        birds = new Bird[5];
        for (int i = 0; i < birds.length; i++) {
            int bx = rand.nextInt(WIDTH - 80) + 40;
            int by = 60 + rand.nextInt(GROUND_Y - 160);
            birds[i] = new Bird(bx, by);
        }
        fish = new Fish[4];
        for (int i = 0; i < fish.length; i++) {
            int fx = LAKE_X + 20 + rand.nextInt(LAKE_W - 40);
            int fy = LAKE_Y + 20 + rand.nextInt(LAKE_H - 40);
            fish[i] = new Fish(fx, fy);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, WIDTH, GROUND_Y);

        g.setColor(new Color(95, 170, 95));
        g.fillRect(0, GROUND_Y, WIDTH, HEIGHT - GROUND_Y);

        drawHouse(g);
        drawLake(g);

        for (Grass gr : grasses) gr.drawMe(g);
        for (Tree t : myTrees) t.drawMe(g);
        for (Cloud c : clouds) c.drawMe(g);

        for (Fish f : fish) f.drawMe(g);
        for (Bird b : birds) b.drawMe(g);
        dog.drawMe(g);
    }

    private void drawHouse(Graphics g) {
        int x = 120, y = GROUND_Y - 80, w = 140, h = 80;
        g.setColor(new Color(220, 180, 140));
        g.fillRect(x, y, w, h);
        g.setColor(new Color(150, 70, 50));
        int[] xs = {x - 10, x + w / 2, x + w + 10};
        int[] ys = {y, y - 50, y};
        g.fillPolygon(xs, ys, 3);
        g.setColor(new Color(80, 60, 40));
        g.fillRect(x + 60, y + 35, 28, 45);
        g.setColor(new Color(180, 230, 250));
        g.fillRect(x + 20, y + 20, 30, 24);
        g.fillRect(x + 90, y + 20, 30, 24);
    }

    private void drawLake(Graphics g) {
        g.setColor(new Color(70, 150, 220));
        g.fillOval(LAKE_X, LAKE_Y, LAKE_W, LAKE_H);
    }

    public void animate() {
        while (true) {
            for (Cloud c : clouds) c.move();
            dog.move();
            for (Bird b : birds) b.move();
            for (Fish f : fish) f.move();
            try { Thread.sleep(12); } catch (InterruptedException ex) { Thread.currentThread().interrupt(); }
            repaint();
        }
    }

    private static class Tree {
        private int x, y;
        public Tree(int x, int y) { this.x = x; this.y = y; }
        public void drawMe(Graphics g) {
            g.setColor(new Color(110, 70, 40));
            g.fillRect(x - 5, y - 30, 10, 30);
            g.setColor(new Color(34, 139, 34));
            g.fillOval(x - 25, y - 60, 50, 30);
            g.fillOval(x - 35, y - 48, 50, 30);
            g.fillOval(x - 5,  y - 48, 50, 30);
        }
    }

    private static class Cloud {
        private int x, y, w, h, panelWidth;
        public Cloud(int x, int y, int w, int h, int panelWidth) {
            this.x = x; this.y = y; this.w = w; this.h = h; this.panelWidth = panelWidth;
        }
        public void move() {
            x += 1;
            if (x > panelWidth + w) x = -w;
        }
        public void drawMe(Graphics g) {
            g.setColor(new Color(200, 200, 210));
            g.fillOval(x, y, w, h);
        }
    }

    private static class Grass {
        private int x, y, h;
        public Grass(int x, int y, int h) { this.x = x; this.y = y; this.h = h; }
        public void drawMe(Graphics g) {
            g.setColor(new Color(20, 120, 40));
            g.fillRect(x, y - h, 2, h);
        }
    }

    private class Dog {
        private int x, y;
        private int dx = rand.nextBoolean() ? 2 : -2;
        private int dy = 0;
        public Dog(int x, int y) { this.x = x; this.y = y; }
        public void move() {
            if (rand.nextInt(30) == 0) dx = rand.nextInt(3) - 1 == 0 ? dx : (rand.nextBoolean() ? 2 : -2);
            if (rand.nextInt(40) == 0) dy = rand.nextInt(3) - 1;
            x += dx;
            y += dy;
            int minY = GROUND_Y - 28;
            int maxY = HEIGHT - 16;
            if (x < 20) x = 20;
            if (x > WIDTH - 20) x = WIDTH - 20;
            if (y < minY) y = minY;
            if (y > maxY) y = maxY;
        }
        public void drawMe(Graphics g) {
            g.setColor(new Color(160, 110, 70));
            g.fillOval(x - 22, y - 10, 44, 20);
            g.fillOval(x + 10, y - 16, 16, 16);
            g.setColor(Color.BLACK);
            g.fillOval(x + 20, y - 12, 3, 3);
            g.setColor(new Color(120, 80, 50));
            g.fillRect(x - 14, y + 6, 6, 10);
            g.fillRect(x + 8,  y + 6, 6, 10);
            g.setColor(new Color(110, 70, 40));
            g.drawLine(x - 26, y - 6, x - 14, y - 12);
        }
    }

    private class Bird {
        private int x, y;
        private int dx = rand.nextBoolean() ? 2 : -2;
        private int dy = rand.nextBoolean() ? 1 : -1;
        public Bird(int x, int y) { this.x = x; this.y = y; }
        public void move() {
            if (rand.nextInt(25) == 0) dx = rand.nextBoolean() ? 2 : -2;
            if (rand.nextInt(25) == 0) dy = rand.nextBoolean() ? 1 : -1;
            x += dx; y += dy;
            int minY = 40;
            int maxY = GROUND_Y - 90;
            if (x < -30) x = WIDTH + 30;
            if (x > WIDTH + 30) x = -30;
            if (y < minY) y = minY;
            if (y > maxY) y = maxY;
        }
        public void drawMe(Graphics g) {
            g.setColor(new Color(230, 230, 240));
            g.fillOval(x - 12, y - 8, 24, 16);
            g.setColor(new Color(240, 180, 0));
            g.fillPolygon(new int[]{x + 12, x + 20, x + 12}, new int[]{y - 1, y + 3, y + 6}, 3);
            g.setColor(Color.BLACK);
            g.fillOval(x + 6, y - 3, 3, 3);
        }
    }

    private class Fish {
        private int x, y;
        private int dx = rand.nextBoolean() ? 2 : -2;
        private int dy = rand.nextBoolean() ? 1 : -1;
        public Fish(int x, int y) { this.x = x; this.y = y; }
        public void move() {
            if (rand.nextInt(30) == 0) dx = rand.nextBoolean() ? 2 : -2;
            if (rand.nextInt(30) == 0) dy = rand.nextBoolean() ? 1 : -1;
            x += dx; y += dy;
            int minX = LAKE_X + 10, maxX = LAKE_X + LAKE_W - 10;
            int minY = LAKE_Y + 10, maxY = LAKE_Y + LAKE_H - 10;
            if (x < minX) { x = minX; dx = 2; }
            if (x > maxX) { x = maxX; dx = -2; }
            if (y < minY) { y = minY; dy = 1; }
            if (y > maxY) { y = maxY; dy = -1; }
        }
        public void drawMe(Graphics g) {
            g.setColor(new Color(240, 120, 120));
            g.fillOval(x - 10, y - 6, 20, 12);
            g.setColor(new Color(200, 80, 80));
            g.fillPolygon(new int[]{x - 10, x - 18, x - 10}, new int[]{y - 6, y, y + 6}, 3);
            g.setColor(Color.WHITE);
            g.fillOval(x + 4, y - 3, 4, 4);
            g.setColor(Color.BLACK);
            g.fillOval(x + 6, y - 1, 2, 2);
        }
    }
}