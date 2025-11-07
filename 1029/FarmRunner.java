import javax.swing.*;

public class FarmRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Farm Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Farm());
        frame.pack();
        frame.setVisible(true);
    }
}
