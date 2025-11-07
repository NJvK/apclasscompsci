import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame f = new JFrame("Number Slots");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Screen());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}