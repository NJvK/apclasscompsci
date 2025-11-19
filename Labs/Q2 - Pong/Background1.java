import java.awt.*;
import javax.swing.*;

public class Background1 extends JPanel {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200, 700);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 1. Draw Background
        drawBackground(g);
    }
    public void drawBackground(Graphics g) {
        // Light Blue for Day
        g.setColor(Color.black);
        g.fillRect(0, 0, 1200, 700);
    }
}