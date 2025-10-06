package Q1;
import javax.swing.JFrame;
public class Runner {
    public static void main(String[] args) {
        Scenery scenery = new Scenery();
        JFrame frame = new JFrame("Scenery");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scenery);
        frame.pack();
        frame.setVisible(true);
    }
}
