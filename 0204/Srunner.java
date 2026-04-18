import javax.swing.JFrame;

public class Srunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Screen s = new Screen();
        frame.setContentPane(s);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}