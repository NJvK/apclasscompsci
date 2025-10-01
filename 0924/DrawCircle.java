import java.awt.Color;
import javax.swing.JFrame;
public class DrawCircle {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Circle circle = new Circle();
        frame.add(circle);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
    }
}