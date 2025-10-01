import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Scenery extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        Color brownColor = new Color(139, 69, 19);
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(370, 0, 50, 50);
        g.drawOval(370, 0, 50, 50);
        g.setColor(Color.GREEN);
        g.drawRect(0, 300, 400, 100);
        g.fillRect(0, 300, 400, 100);
        //------------Tree----------------------------
        g.setColor(brownColor);
        g.drawRect(75, 200, 50, 100);
        g.fillRect(75, 200, 50, 100);
        g.setColor(Color.GREEN);
        g.drawOval(65, 150, 100, 100);
        g.fillOval(65, 150, 100, 100);
        //------------Tree----------------------------
        g.setColor(brownColor);
        g.drawRect(200, 220, 50, 80);
        g.fillRect(200, 220, 50, 80);
        g.setColor(Color.GREEN);
        g.drawOval(190, 175, 100, 100);
        g.fillOval(190, 175, 100, 100);
        //------------Tree---------------------------
        g.setColor(brownColor);
        g.drawRect(275, 200, 50, 100);
        g.fillRect(275, 200, 50, 100);
        g.setColor(Color.GREEN);
        g.drawOval(245, 175, 100, 100);
        g.fillOval(245, 175, 100, 100);
        //------------Lake---------------------------
        g.setColor(Color.CYAN);
        g.drawOval(50, 320, 100, 50);
        g.fillOval(50, 320, 100, 50);
    }
}