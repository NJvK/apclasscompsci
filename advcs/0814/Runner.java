import java.swing.JFrame;
public class Runner {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.display();
        JFrame frame = new JFrame("Screen Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
