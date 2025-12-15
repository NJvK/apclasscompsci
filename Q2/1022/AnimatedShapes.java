import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedShapes extends JPanel implements ActionListener {

    // Window size
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    // Timer for animation
    private final Timer timer = new Timer(16, this);

    // Circle
    private int cX = 100, cY = 100, cDX = 3, cDY = 2, cSize = 50;

    // Square
    private int sX = 300, sY = 300, sDX = -2, sDY = 1, sSize = 50;

    // Triangle
    private int tX = 500, tY = 150, tDX = 1, tDY = -3, tBase = 50, tHeight = 50;

    // Oval
    private int oX = 200, oY = 420, oDX = 2, oDY = -2, oW = 80, oH = 40;

    // Star
    private int stX = 620, stY = 250, stDX = -3, stDY = 2, stOuter = 25, stInner = 10;

    // Sets window properties
    public AnimatedShapes() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(150, 200, 255));
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveAll();
        repaint();
    }

    private void moveAll() {
        // Make each shape move with velocity
        cX += cDX; cY += cDY;
        sX += sDX; sY += sDY;
        tX += tDX; tY += tDY;
        oX += oDX; oY += oDY;
        stX += stDX; stY += stDY;

        // Does not go out of window bounds
        // Circle
        if (cX < 0 || cX > WIDTH - cSize) cDX *= -1;
        if (cY < 0 || cY > HEIGHT - cSize) cDY *= -1;

        // Square
        if (sX < 0 || sX > WIDTH - sSize) sDX *= -1;
        if (sY < 0 || sY > HEIGHT - sSize) sDY *= -1;

        // Triangle
        int triW = tBase;
        int triH = tHeight;
        if (tX - triW/2 < 0 || tX + triW/2 > WIDTH) tDX *= -1;
        if (tY < 0 || tY + triH > HEIGHT) tDY *= -1;

        // Oval
        if (oX < 0 || oX > WIDTH - oW) oDX *= -1;
        if (oY < 0 || oY > HEIGHT - oH) oDY *= -1;

        // Star
        int r = stOuter;
        if (stX - r < 0 || stX + r > WIDTH) stDX *= -1;
        if (stY - r < 0 || stY + r > HEIGHT) stDY *= -1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Circle
        g2.setColor(Color.RED);
        g2.fillOval(cX, cY, cSize, cSize);

        // Square
        g2.setColor(Color.BLUE);
        g2.fillRect(sX, sY, sSize, sSize);

        // Triangle
        g2.setColor(Color.GREEN);
        int[] tx = { tX, tX + tBase/2, tX - tBase/2 };
        int[] ty = { tY, tY + tHeight, tY + tHeight };
        g2.fillPolygon(tx, ty, 3);

        // Oval
        g2.setColor(Color.YELLOW);
        g2.fillOval(oX, oY, oW, oH);

        // Star
        g2.setColor(Color.MAGENTA);
        fillStar(g2, stX, stY, stOuter, stInner, 5);
    }
    // Fills in star
    private void fillStar(Graphics2D g2, int cx, int cy, int outerR, int innerR, int n) {
        int totalPoints = n * 2;
        int[] xs = new int[totalPoints];
        int[] ys = new int[totalPoints];

        double step = Math.PI / n;
        double startAngle = -Math.PI / 2.0;

        for (int i = 0; i < totalPoints; i++) {
            double angle = startAngle + i * step;
            int r = (i % 2 == 0) ? outerR : innerR;
            xs[i] = (int) (cx + r * Math.cos(angle));
            ys[i] = (int) (cy + r * Math.sin(angle));
        }
        g2.fillPolygon(xs, ys, totalPoints);
    }

    public static void main(String[] args) {
        // Create the window and add the animated panel
        JFrame frame = new JFrame("Animated Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AnimatedShapes());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}