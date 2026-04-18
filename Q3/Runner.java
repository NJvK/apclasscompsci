import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quarter 3 Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Table t = new Table();
        frame.add(t);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}