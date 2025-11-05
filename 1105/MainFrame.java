import javax.swing.*;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scene");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Scene scene = new Scene();
        frame.add(scene);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}