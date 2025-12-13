import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2 Player Galaga");
        Screen screen = new Screen();

        frame.add(screen);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        screen.animate();
    }
}