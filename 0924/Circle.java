import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class Circle extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(370, 0, 50, 50);
        g.drawOval(370, 0, 50, 50);
        g.drawRect(0, 300, 400, 100);
        g.setColor(Color.GREEN);
        g.fillRect(0, 300, 400, 100);
        g.setColor(Color.BLACK);
        g.drawRect(175, 100, 50, 200);
        g.fillRect(175, 100, 50, 200);
        g.setColor(Color.GREEN);
        g.drawOval(150, 0, 150, 125);
        g.fillOval(150, 0, 150, 125);

    }
}