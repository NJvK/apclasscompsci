import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JPanel implements ActionListener {
    private BlackJack game;

    private JButton hitBtn;
    private JButton standBtn;
    private JButton playAgainBtn;

    public Table() {
        game = new BlackJack();

        setLayout(null);
        setPreferredSize(new Dimension(900, 600));

        hitBtn = new JButton("Hit");
        standBtn = new JButton("Stand");
        playAgainBtn = new JButton("Play Again");

        hitBtn.setBounds(40, 30, 120, 35);
        standBtn.setBounds(180, 30, 120, 35);
        playAgainBtn.setBounds(320, 30, 140, 35);

        hitBtn.addActionListener(this);
        standBtn.addActionListener(this);
        playAgainBtn.addActionListener(this);

        add(hitBtn);
        add(standBtn);
        add(playAgainBtn);

        updateButtons();
    }

    private void updateButtons() {
        boolean over = game.isGameOver();

        hitBtn.setEnabled(!over);
        standBtn.setEnabled(!over);

        if (game.getPoints() <= 0 && over) {
            playAgainBtn.setEnabled(false);
        } else {
            playAgainBtn.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == hitBtn) {
            game.hit();
        } else if (src == standBtn) {
            game.stand();
        } else if (src == playAgainBtn) {
            game.newGame();
        }

        updateButtons();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.drawString("One-Player Blackjack (Ace = 11)", 520, 40);

        g.drawString("Total: " + game.getHandValue(), 520, 70);
        g.drawString("Points: " + game.getPoints(), 520, 95);

        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("Instructions: Hit to draw. Stand to end. Win only if you stand with 16–21.", 40, 90);
        g.drawString("Each new game costs 1 point.", 40, 110);

        drawHand(g);
        drawPointsTable(g);
        drawEndMessage(g);
    }

    private void drawHand(Graphics g) {
        int x = 40;
        int y = 150;

        g.setFont(new Font("SansSerif", Font.BOLD, 16));
        g.drawString("Your Hand:", x, y - 15);

        Card[] hand = game.getHand();
        int size = game.getHandSize();

        g.setFont(new Font("SansSerif", Font.PLAIN, 14));

        for (int i = 0; i < size; i++) {
            int cardX = x + i * 140;
            int cardY = y;

            g.drawRect(cardX, cardY, 120, 80);
            g.drawString(hand[i].getName(), cardX + 10, cardY + 25);
            g.drawString(hand[i].getSuit(), cardX + 10, cardY + 50);
            g.drawString("Value: " + hand[i].getValue(), cardX + 10, cardY + 70);
        }
    }

    private void drawPointsTable(Graphics g) {
        int x = 40;
        int y = 300;

        g.setFont(new Font("SansSerif", Font.BOLD, 16));
        g.drawString("Winning Points Table (stand with 16–21):", x, y);

        g.setFont(new Font("SansSerif", Font.PLAIN, 14));

        String[] rows = {
                "21  ->  5 points",
                "20  ->  3 points",
                "19  ->  2 points",
                "18  ->  2 points",
                "17  ->  1 point",
                "16  ->  1 point"
        };

        int boxW = 220;
        int boxH = 24;

        for (int i = 0; i < rows.length; i++) {
            int ry = y + 25 + i * boxH;
            g.drawRect(x, ry - 18, boxW, boxH);
            g.drawString(rows[i], x + 10, ry);
        }

        g.drawString("Lose if total < 16 or total > 21.", x, y + 25 + rows.length * boxH + 20);
    }

    private void drawEndMessage(Graphics g) {
        int x = 40;
        int y = 520;

        g.setFont(new Font("SansSerif", Font.BOLD, 18));

        if (game.isGameOver()) {
            g.drawString("Result: " + game.getEndMessage(), x, y);

            int won = game.getLastWinPoints();
            if (won > 0) {
                g.setFont(new Font("SansSerif", Font.PLAIN, 16));
                g.drawString("You earned " + won + " point(s) this round.", x, y + 25);
            }
        } else {
            g.drawString("Result: (not finished)", x, y);
        }

        if (game.getPoints() <= 0 && game.isGameOver()) {
            g.setFont(new Font("SansSerif", Font.PLAIN, 16));
            g.drawString("You are out of points. Game over.", x, y + 50);
        }
    }
}