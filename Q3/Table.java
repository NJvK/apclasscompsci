import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Table extends JPanel implements ActionListener, MouseListener, KeyListener {

    private CardGame game;

    private JButton playBtn;
    private JButton passBtn;
    private JButton nextPlayerBtn;
    private JButton newGameBtn;

    // screens: 0=start, 1=game, 2=end, 3=blank transfer
    private int screen;

    private ArrayList<Integer> selected;

    // card layout (wrapped)
    private int startX = 20;
    private int startY = 160;

    private int cardW = 70;
    private int cardH = 95;

    private int gapX = 10;
    private int gapY = 20;

    private int liftSelected = 12;

    public Table() {
        setPreferredSize(new Dimension(900, 600));
        setLayout(null);
        setFocusable(true);

        game = new CardGame();
        selected = new ArrayList<Integer>();

        playBtn = new JButton("Play Selected");
        passBtn = new JButton("Pass");
        nextPlayerBtn = new JButton("Next Player");
        newGameBtn = new JButton("New Game");

        playBtn.setBounds(20, 95, 140, 30);
        passBtn.setBounds(170, 95, 90, 30);
        nextPlayerBtn.setBounds(270, 95, 120, 30);
        newGameBtn.setBounds(400, 95, 110, 30);

        add(playBtn);
        add(passBtn);
        add(nextPlayerBtn);
        add(newGameBtn);

        playBtn.addActionListener(this);
        passBtn.addActionListener(this);
        nextPlayerBtn.addActionListener(this);
        newGameBtn.addActionListener(this);

        addMouseListener(this);
        addKeyListener(this);

        screen = 0; // start screen
        updateButtonVisibility();
    }

    private void updateButtonVisibility() {
        boolean inGame = (screen == 1);

        playBtn.setVisible(inGame);
        passBtn.setVisible(inGame);

        nextPlayerBtn.setVisible(screen == 3);
        newGameBtn.setVisible(screen == 2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (screen == 0) {
            drawStartScreen(g);
        } else if (screen == 1) {
            drawGameScreen(g);
        } else if (screen == 3) {
            drawTransferScreen(g);
        } else {
            drawEndScreen(g);
        }
    }

    private void drawStartScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, 28));
        g.drawString("Card Game: Get Rid of Your Cards", 20, 60);

        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        int y = 110;
        g.drawString("Rules:", 20, y); y += 22;
        g.drawString("- Deal all cards. Whoever has the 3 of clubs goes first.", 20, y); y += 22;
        g.drawString("- 2s are high.", 20, y); y += 22;
        g.drawString("- Goal: be the first to play all your cards.", 20, y); y += 22;
        g.drawString("- Play is clockwise. You may Play or Pass.", 20, y); y += 22;
        g.drawString("- A play must be a set of the same rank (ex: two 7s).", 20, y); y += 22;
        g.drawString("- To beat a play: play the same number of cards or more, of a higher rank.", 20, y); y += 22;
        g.drawString("- If everyone passes, the last person who played starts fresh (any set allowed).", 20, y); y += 22;

        y += 20;
        g.drawString("Controls:", 20, y); y += 22;
        g.drawString("- Click cards to select/unselect them.", 20, y); y += 22;
        g.drawString("- Use buttons: Play Selected / Pass.", 20, y); y += 22;
        g.drawString("- Press 'p' to jump Start -> Game -> End (cheat key).", 20, y); y += 22;

        y += 30;
        g.setFont(new Font("SansSerif", Font.BOLD, 18));
        g.drawString("Press 'p' to begin.", 20, y);
    }

    private void drawGameScreen(Graphics g) {
        game.drawGameInfo(g, getWidth());

        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("Click cards to select. Then Play Selected (must be valid) or Pass.", 20, 120);

        drawHandWrapped(g);

        g.setColor(Color.DARK_GRAY);
        g.drawString("After you play/pass, the screen will hide hands while passing the computer.", 20, getHeight() - 30);
    }

    private void drawTransferScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        g.drawString("PASS COMPUTER", 290, 250);

        g.setFont(new Font("SansSerif", Font.PLAIN, 18));
        g.drawString("Hands are hidden. Next player: Player " + (game.getCurrentPlayer() + 1), 270, 290);

        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("Press the button to continue.", 360, 330);
    }

    private void drawEndScreen(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.BOLD, 32));
        g.drawString("Game Over", 20, 60);

        g.setFont(new Font("SansSerif", Font.PLAIN, 20));
        g.drawString("Winner: Player " + (game.getWinner() + 1), 20, 110);

        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.drawString("Stats:", 20, 150);
        g.drawString("Player 1 cards left: " + game.getHand(0).size(), 20, 175);
        g.drawString("Player 2 cards left: " + game.getHand(1).size(), 20, 200);

        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.drawString("Press 'p' to cycle screens or click New Game.", 20, 250);
    }

    private int cardsPerRow(int drawW) {
        return Math.max(1, (getWidth() - startX * 2) / (drawW + gapX));
    }

    private void drawHandWrapped(Graphics g) {
        ArrayList<Card> hand = game.getHand(game.getCurrentPlayer());

        int drawW = cardW;
        int drawH = cardH;

        // Optional: shrink cards if hand is large so everything fits on screen
        if (hand.size() > 20) {
            drawW = 55;
            drawH = 75;
        }

        int perRow = cardsPerRow(drawW);

        for (int i = 0; i < hand.size(); i++) {
            int row = i / perRow;
            int col = i % perRow;

            int x = startX + col * (drawW + gapX);
            int y = startY + row * (drawH + gapY);

            boolean isSelected = selected.contains(i);
            if (isSelected) y -= liftSelected;

            hand.get(i).draw(g, x, y, drawW, drawH, isSelected);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        requestFocusInWindow();

        if (e.getSource() == playBtn && screen == 1) {
            boolean ok = game.playSelected(selected);
            if (ok) {
                selected.clear();

                if (game.isGameOver()) {
                    screen = 2;
                } else {
                    screen = 3; // transfer
                }
                updateButtonVisibility();
                repaint();
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        if (e.getSource() == passBtn && screen == 1) {
            selected.clear();
            game.passTurn();

            if (game.isGameOver()) {
                screen = 2;
            } else {
                screen = 3;
            }
            updateButtonVisibility();
            repaint();
        }

        if (e.getSource() == nextPlayerBtn && screen == 3) {
            screen = 1;
            updateButtonVisibility();
            repaint();
        }

        if (e.getSource() == newGameBtn && screen == 2) {
            game.newGame();
            selected.clear();
            screen = 0;
            updateButtonVisibility();
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
        if (screen != 1) return;

        int mx = e.getX();
        int my = e.getY();

        ArrayList<Card> hand = game.getHand(game.getCurrentPlayer());

        int drawW = cardW;
        int drawH = cardH;

        if (hand.size() > 20) {
            drawW = 55;
            drawH = 75;
        }

        int perRow = cardsPerRow(drawW);

        for (int i = 0; i < hand.size(); i++) {
            int row = i / perRow;
            int col = i % perRow;

            int x = startX + col * (drawW + gapX);
            int y = startY + row * (drawH + gapY);

            boolean isSelected = selected.contains(i);
            if (isSelected) y -= liftSelected;

            Rectangle r = new Rectangle(x, y, drawW, drawH);
            if (r.contains(mx, my)) {
                toggleSelected(i);
                repaint();
                return;
            }
        }
    }

    private void toggleSelected(int idx) {
        if (selected.contains(idx)) {
            selected.remove((Integer) idx);
        } else {
            selected.add(idx);
            sortSelected();
        }
    }

    private void sortSelected() {
        for (int i = 0; i < selected.size(); i++) {
            for (int j = 0; j < selected.size() - 1; j++) {
                if (selected.get(j) > selected.get(j + 1)) {
                    int temp = selected.get(j);
                    selected.set(j, selected.get(j + 1));
                    selected.set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'p' || e.getKeyChar() == 'P') {
            if (screen == 0) screen = 1;
            else if (screen == 1) screen = 2;
            else if (screen == 2) screen = 0;
            else if (screen == 3) screen = 1;

            updateButtonVisibility();
            repaint();
        }
    }

    // unused required methods
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}