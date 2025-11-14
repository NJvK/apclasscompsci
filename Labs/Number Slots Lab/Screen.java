import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Screen extends JPanel implements ActionListener {
    private static final int W = 640;
    private static final int H = 420;
    private final SlotMachine machine = new SlotMachine(100);
    private final JButton spinBtn = new JButton("Spin");
    private final Timer repaintTimer = new Timer(16, this);
    private long winStart = 0;
    private final int winMs = 1200;
    private final int boxX = 80, boxY = 70, boxW = 480, boxH = 180;

    public Screen() {
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
        setFocusable(true);
        spinBtn.setBounds(260, 330, 120, 36);
        spinBtn.addActionListener(e -> onSpin());
        add(spinBtn);
        repaintTimer.start();
        updateControls();
    }

    private void onSpin() {
        if (!machine.canSpin()) return;
        machine.play();
        updateControls();
        if (machine.getWinnings() > 0) winStart = System.currentTimeMillis();
        repaint();
    }

    private void updateControls() {
        spinBtn.setEnabled(machine.canSpin());
        spinBtn.setText(machine.canSpin() ? "Spin" : "Out of Points");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(30, 30, 35));
        g.fillRect(0, 0, W, H);
        drawMachine(g);
        drawPayoutTable(g);
        drawBalanceAndWinnings(g);
        drawWinBannerAndPulse(g);
    }

    private void drawMachine(Graphics g) {
        g.setColor(new Color(240, 240, 245));
        g.fillRoundRect(boxX, boxY, boxW, boxH, 18, 18);
        g.setColor(new Color(50, 50, 60));
        g.drawRoundRect(boxX, boxY, boxW, boxH, 18, 18);
        int reelW = (boxW - 40) / 3;
        int reelH = boxH - 40;
        int rx = boxX + 20;
        int ry = boxY + 20;
        g.setColor(new Color(235, 235, 240));
        for (int i = 0; i < 3; i++) {
            int x = rx + i * (reelW + 10);
            g.fillRoundRect(x, ry, reelW, reelH, 12, 12);
            g.setColor(new Color(60, 60, 70));
            g.drawRoundRect(x, ry, reelW, reelH, 12, 12);
            g.setColor(new Color(235, 235, 240));
        }
        Font font = new Font("Arial", Font.BOLD, 64);
        g.setFont(font);
        g.setColor(new Color(20, 20, 30));
        String s1 = valToStr(machine.getNum1());
        String s2 = valToStr(machine.getNum2());
        String s3 = valToStr(machine.getNum3());
        drawCentered(g, s1, rx + reelW / 2, ry + reelH / 2 + 22);
        drawCentered(g, s2, rx + (reelW + 10) + reelW / 2, ry + reelH / 2 + 22);
        drawCentered(g, s3, rx + 2 * (reelW + 10) + reelW / 2, ry + reelH / 2 + 22);
    }

    private String valToStr(int v) {
        return v == 0 ? "-" : Integer.toString(v);
    }

    private void drawPayoutTable(Graphics g) {
        int x = 60, y = 270;
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(new Color(235, 235, 245));
        g.drawString("Payouts:", x, y);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("777 = +100 points", x, y + 20);
        g.drawString("3 of a kind = +5 points", x, y + 40);
        g.drawString("2 of a kind = +1 point", x, y + 60);
        g.drawString("Cost per spin = 1 point", x, y + 80);
    }

    private void drawBalanceAndWinnings(Graphics g) {
        int x = 420, y = 270;
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(new Color(235, 235, 245));
        g.drawString("Balance: " + machine.getBalance(), x, y);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Last winnings: " + machine.getWinnings(), x, y + 24);
        if (!machine.canSpin()) {
            g.setColor(new Color(255, 120, 120));
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("No points left. Game over.", x, y + 48);
        }
    }

    private void drawCentered(Graphics g, String s, int cx, int cy) {
        FontMetrics fm = g.getFontMetrics();
        int w = fm.stringWidth(s);
        int h = fm.getAscent();
        g.drawString(s, cx - w / 2, cy - h / 2);
    }

    private void drawWinBannerAndPulse(Graphics g) {
        int win = machine.getWinnings();
        if (win <= 0) return;
        long elapsed = System.currentTimeMillis() - winStart;
        if (elapsed > winMs) return;
        double t = elapsed / (double) winMs;
        int thickness = 1 + (int) Math.round(5 * Math.abs(Math.sin(t * Math.PI * 4)));
        boolean blink = ((elapsed / 120) % 2) == 0;
        Color borderColor = blink ? new Color(255, 215, 0) : new Color(255, 255, 255);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect(boxX - 6, boxY - 6, boxW + 12, boxH + 12, 22, 22);
        g2.dispose();
        String msg = "YOU WIN +" + win;
        g.setFont(new Font("Arial", Font.BOLD, 28));
        g.setColor(new Color(30, 30, 35, 150));
        drawCentered(g, msg, W / 2 + 2, boxY - 10 + 2);
        g.setColor(borderColor);
        drawCentered(g, msg, W / 2, boxY - 10);
    }
}