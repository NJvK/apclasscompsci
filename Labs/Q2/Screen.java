import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements KeyListener, ActionListener {

    private Game game;
    private Timer timer;

    public Screen() {
        game = new Game();
        setFocusable(true);
        addKeyListener(this);
    }

    public void animate() {
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.update();
        repaint();
        requestFocus();
        setFocusable(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}