import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Blackjack - MVHS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Table panel = new Table();
        frame.setContentPane(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}