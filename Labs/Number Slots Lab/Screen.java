import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel implements ActionListener {
    private static final int W = 640;
    private static final int H = 420;

    private final SlotMachine machine = new SlotMachine(100);
    private final JButton spinBtn = new JButton("Spin");

    // Animation timer (~60 FPS)
    private final Timer repaintTimer = new Timer(16, this);

    // Win animation particles
    private final ArrayList<Particle> particles = new ArrayList<>();
    private final Random rand = new Random();

    // Reel area for reference (so particles appear near the reels)
    private final Rectangle reelArea = new Rectangle(80 + 20, 70 + 20, (480 - 40), (180 - 40));

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

        if (machine.getWinnings() > 0) {
            startWinAnimation(machine.getWinnings());
        }

        repaint();
    }

    private void updateControls() {
        spinBtn.setEnabled(machine.canSpin());
        spinBtn.setText(machine.canSpin() ? "Spin" : "Out of Points");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update particles
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            p.update();
            if (!p.alive()) particles.remove(i);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(new Color(30, 30, 35));
        g.fillRect(0, 0, W, H);

        drawMachine(g);
        drawPayoutTable(g);
        drawBalanceAndWinnings(g);
        drawParticles(g);
    }

    private void drawMachine(Graphics g) {
        int x = 80, y = 70, boxW = 480, boxH = 180;

        g.setColor(new Color(240, 240, 245));
        g.fillRoundRect(x, y, boxW, boxH, 18, 18);
        g.setColor(new Color(50, 50, 60));
        g.drawRoundRect(x, y, boxW, boxH, 18, 18);

        int reelW = (boxW - 40) / 3;
        int reelH = boxH - 40;
        int rx = x + 20;
        int ry = y + 20;

        g.setColor(new Color(235, 235, 240));
        for (int i = 0; i < 3; i++) {
            g.fillRoundRect(rx + i * (reelW + 10), ry, reelW, reelH, 12, 12);
            g.setColor(new Color(60, 60, 70));
            g.drawRoundRect(rx + i * (reelW + 10), ry, reelW, reelH, 12, 12);
            g.setColor(new Color(235, 235, 240));
        }

        // Numbers
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

    // Win animation: confetti/coins bursting above the reels
    private void startWinAnimation(int amount) {
        // Spawn count scales a bit with winnings
        int count = Math.min(150, 40 + amount / 2);

        int cx = reelArea.x + reelArea.width / 2;
        int cy = reelArea.y; // burst from top of reels

        for (int i = 0; i < count; i++) {
            double angle = rand.nextDouble() * Math.PI - Math.PI / 2.0; // upward spread
            double speed = 2.0 + rand.nextDouble() * 4.0;

            double vx = Math.cos(angle) * speed;
            double vy = -Math.abs(Math.sin(angle) * speed) - (1 + rand.nextDouble() * 1.5);

            Color c = pickParticleColor(amount);
            int size = 3 + rand.nextInt(4);
            int life = 30 + rand.nextInt(25); // frames

            particles.add(new Particle(cx, cy, vx, vy, size, life, c));
        }
    }
    // for animation ----------------------------------
    private Color pickParticleColor(int amount) {
        if (amount >= 100) return new Color(255, 215, 0);
        if (amount >= 5)   return new Color(120, 200, 255);
        return new Color(160, 255, 160);
    }

    private void drawParticles(Graphics g) {
        for (Particle p : particles) {
            g.setColor(p.colorWithFade());
            g.fillOval((int) p.x, (int) p.y, p.size, p.size);
        }
    }

    private class Particle {
        double x, y;
        double vx, vy;
        int size;
        int life;
        final int maxLife;
        final Color base;

        Particle(double x, double y, double vx, double vy, int size, int life, Color c) {
            this.x = x; this.y = y;
            this.vx = vx; this.vy = vy;
            this.size = size;
            this.life = life;
            this.maxLife = life;
            this.base = c;
        }

        void update() {
            x += vx;
            y += vy;

            vy += 0.12;
            vx *= 0.99;

            life--;
        }

        boolean alive() { return life > 0; }

        Color colorWithFade() {
            float a = Math.max(0f, life / (float) maxLife);
            int r = (int)(base.getRed()   * (0.5 + 0.5 * a));
            int g = (int)(base.getGreen() * (0.5 + 0.5 * a));
            int b = (int)(base.getBlue()  * (0.5 + 0.5 * a));
            return new Color(clamp(r), clamp(g), clamp(b), (int)(255 * a));
        }

        private int clamp(int v) { return Math.max(0, Math.min(255, v)); }
    }
}
