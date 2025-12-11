import java.awt.Color;
import java.awt.Graphics;

public class Drawings {

    // player 1 ship at (p1x, p1y)
    public void player1(Graphics g, int p1x, int p1y) {
        Color lightblue = new Color(173, 216, 230);
        Color blue = new Color(73, 157, 208);

        int[] x1 = new int[4];
        int[] y1 = new int[4];

        int[] x2 = new int[4];
        int[] y2 = new int[4];

        x1[0] = p1x;
        x1[1] = p1x - 30;
        x1[2] = p1x;
        x1[3] = p1x + 30;
        y1[0] = p1y;
        y1[1] = p1y + 50;
        y1[2] = p1y + 30;
        y1[3] = p1y + 50;

        x2[0] = p1x;
        x2[1] = p1x - 33;
        x2[2] = p1x;
        x2[3] = p1x + 33;
        y2[0] = p1y;
        y2[1] = p1y + 35;
        y2[2] = p1y + 20;
        y2[3] = p1y + 35;

        g.setColor(blue);
        g.fillPolygon(x2, y2, 4);
        g.setColor(lightblue);
        g.fillPolygon(x1, y1, 4);
    }

    // player 2 ship at (p2x, p2y)
    public void player2(Graphics g, int p2x, int p2y) {
        Color red = new Color(255, 36, 0);
        Color lightred = new Color(255, 127, 127);

        int[] x1 = new int[4];
        int[] y1 = new int[4];

        int[] x2 = new int[4];
        int[] y2 = new int[4];

        x1[0] = p2x;
        x1[1] = p2x - 30;
        x1[2] = p2x;
        x1[3] = p2x + 30;
        y1[0] = p2y;
        y1[1] = p2y - 50;
        y1[2] = p2y - 30;
        y1[3] = p2y - 50;

        x2[0] = p2x;
        x2[1] = p2x - 33;
        x2[2] = p2x;
        x2[3] = p2x + 33;
        y2[0] = p2y;
        y2[1] = p2y - 35;
        y2[2] = p2y - 20;
        y2[3] = p2y - 35;

        g.setColor(red);
        g.fillPolygon(x2, y2, 4);
        g.setColor(lightred);
        g.fillPolygon(x1, y1, 4);
    }

    public void p1bullet(Graphics g, int bx, int by) {
        Color blue = new Color(73, 157, 208);
        Color white = new Color(255, 255, 255);
        g.setColor(blue);
        g.fillRect(bx, by, 7, 15);
        g.setColor(white);
        g.fillRect(bx + 2, by + 4, 3, 8);
    }

    public void p2bullet(Graphics g, int bx, int by) {
        Color red = new Color(255, 36, 0);
        Color white = new Color(255, 255, 255);
        g.setColor(red);
        g.fillRect(bx, by, 7, 15);
        g.setColor(white);
        g.fillRect(bx + 2, by + 4, 3, 8);
    }

    public void asteroid(Graphics g, int ax, int ay) {
        Color brown = new Color(128, 90, 64);
        Color darkbrown = new Color(88, 57, 39);
        g.setColor(brown);
        g.fillOval(ax, ay, 70, 70);
        g.setColor(darkbrown);
        g.fillOval(ax + 5, ay + 25, 35, 35);
        g.fillOval(ax + 10, ay + 10, 15, 15);
        g.fillOval(ax + 35, ay + 40, 20, 20);
    }

    public void endScreen1(Graphics g) {
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        g.setColor(black);
        g.fillRect(0, 0, 800, 600);
        g.setColor(white);
        g.drawString("Winner: Player 1", 300, 300);
        drawPlanet(g);
    }

    public void endScreen2(Graphics g) {
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        g.setColor(black);
        g.fillRect(0, 0, 800, 600);
        g.setColor(white);
        g.drawString("Winner: Player 2", 300, 300);
        drawPlanet(g);
    }

    public void startScreen(Graphics g) {
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        g.setColor(black);
        g.fillRect(0, 0, 800, 600);
        g.setColor(white);
        g.drawString("2 PLAYER GALAGA", 330, 280);

        int[] stars = new int[100];
        for (int i = 0; i < stars.length; i++) {
            int starx = (int) (Math.random() * 801);
            int stary = (int) (Math.random() * 601);
            g.fillOval(starx, stary, 3, 3);
        }
        drawPlanet(g);
    }

    private void drawPlanet(Graphics g) {
        Color red = new Color(255, 36, 0);
        Color blue = new Color(73, 157, 208);
        g.setColor(red);
        g.fillOval(320, 200, 70, 70);
        g.setColor(blue);
        g.drawArc(310, 220, 90, 30, 145, 260);
    }
}