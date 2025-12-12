import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel implements KeyListener, ActionListener {

    private Drawings d = new Drawings();
    private Backgrounds bg = new Backgrounds();

    private Timer timer;

    private boolean startScreen = true;
    private boolean gameOver = false;
    private int winner = 0;

    private int p1Lives = 3;
    private int p2Lives = 3;
    private int p1Score = 0;
    private int p2Score = 0;

    private int p1x = 350;
    private final int p1y = 520;

    private int p2x = 350;
    private final int p2y = 80;

    private boolean p1Left, p1Right;
    private boolean p2Left, p2Right;

    private final int playerSpeed = 12;

    private int p1bx = -100;
    private int p1by = -100;
    private int p2bx = -100;
    private int p2by = -100;

    private final int bulletSpeed = 18;

    private static final int MAX_ASTEROIDS = 5;
    private int[] downAx = new int[MAX_ASTEROIDS];
    private int[] downAy = new int[MAX_ASTEROIDS];
    private int[] upAx = new int[MAX_ASTEROIDS];
    private int[] upAy = new int[MAX_ASTEROIDS];

    private final int downSpeed = 5;
    private final int upSpeed = 5;

    // LEVEL SYSTEM
    private int level = 1;
    private long levelStartTime = System.currentTimeMillis();
    private boolean showingLevelText = true;
    private long levelTextStartTime = System.currentTimeMillis();
    private int activeAsteroids = 2; // Level 1 starts with 2

    private JButton startButton;

    public Game() {
        setFocusable(true);
        addKeyListener(this);
        setLayout(null);

        initAsteroids();

        startButton = new JButton("START");
        startButton.setBounds(340, 320, 120, 40);
        startButton.addActionListener(e -> {
            startScreen = false;
            remove(startButton);
            showingLevelText = true;
            levelTextStartTime = System.currentTimeMillis();
        });
        add(startButton);

        timer = new Timer(16, this);
        timer.start();
    }

    private void initAsteroids() {
        for (int i = 0; i < MAX_ASTEROIDS; i++) {
            downAx[i] = (int)(Math.random() * 730);
            downAy[i] = -70 - (int)(Math.random() * 400);

            upAx[i] = (int)(Math.random() * 730);
            upAy[i] = 600 + (int)(Math.random() * 400);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (startScreen) {
            startButton.setVisible(true);
            d.startScreen(g);
            return;
        } else {
            startButton.setVisible(false);
        }

        if (showingLevelText) {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 32));
            g.drawString("Level " + level, 330, 300);
            return;
        }

        if (gameOver) {
            if (winner == 1) d.endScreen1(g);
            else d.endScreen2(g);
            return;
        }

        drawLevelBackground(g);

        d.player1(g, p1x, p1y);
        d.player2(g, p2x, p2y);

        if (p1by > -20 && p1by < 620) d.p1bullet(g, p1bx, p1by);
        if (p2by > -20 && p2by < 620) d.p2bullet(g, p2bx, p2by);

        for (int i = 0; i < activeAsteroids; i++) d.asteroid(g, downAx[i], downAy[i]);
        for (int i = 0; i < activeAsteroids; i++) d.asteroid(g, upAx[i], upAy[i]);

        drawHUD(g);
    }

    private void drawLevelBackground(Graphics g) {
        if (level == 1) bg.drawBackground1(g);
        else if (level == 2) bg.drawBackground2(g);
        else bg.drawBackground3(g);
    }

    private void drawHUD(Graphics g) {
        g.setColor(Color.white);
        g.drawString("P1 Lives: " + p1Lives + "  Score: " + p1Score, 15, 20);
        g.drawString("P2 Lives: " + p2Lives + "  Score: " + p2Score, 620, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (startScreen || gameOver) {
            repaint();
            return;
        }

        if (showingLevelText) {
            if (System.currentTimeMillis() - levelTextStartTime >= 2000) {
                showingLevelText = false;
                levelStartTime = System.currentTimeMillis();
            }
            repaint();
            return;
        }

        long elapsed = System.currentTimeMillis() - levelStartTime;
        if (elapsed >= 20000) {
            level++;
            if (level > 3) level = 3;

            // If level 3 just finished, end game based on score
            if (level == 3 && elapsed >= 10000) {
                if (p1Score > p2Score) winner = 1;
                else if (p2Score > p1Score) winner = 2;
                else winner = 1; // ties default to Player 1 or choose your logic

                gameOver = true;
                repaint();
                return;
            }


            switch (level) {
                case 1: activeAsteroids = 2; break;
                case 2: activeAsteroids = 3; break;
                case 3: activeAsteroids = 5; break;
            }

            showingLevelText = true;
            levelTextStartTime = System.currentTimeMillis();
            initAsteroids();
        }

        updatePlayers();
        updateBullets();
        updateAsteroids();
        checkCollisions();

        repaint();
    }

    private void updatePlayers() {
        if (p1Left) p1x -= playerSpeed;
        if (p1Right) p1x += playerSpeed;
        if (p2Left) p2x -= playerSpeed;
        if (p2Right) p2x += playerSpeed;

        if (p1x < 40) p1x = 40;
        if (p1x > 760) p1x = 760;
        if (p2x < 40) p2x = 40;
        if (p2x > 760) p2x = 760;
    }

    private void updateBullets() {
        if (p1by > -30) p1by -= bulletSpeed;
        if (p2by < 630) p2by += bulletSpeed;
    }

    private void updateAsteroids() {
        for (int i = 0; i < activeAsteroids; i++) {
            downAy[i] += downSpeed;
            if (downAy[i] > 620) {
                downAy[i] = -70 - (int)(Math.random() * 300);
                downAx[i] = (int)(Math.random() * 730);
            }

            upAy[i] -= upSpeed;
            if (upAy[i] < -80) {
                upAy[i] = 600 + (int)(Math.random() * 300);
                upAx[i] = (int)(Math.random() * 730);
            }
        }
    }

    private void checkCollisions() {
        for (int i = 0; i < activeAsteroids; i++) {
            if (hitAsteroid(p1bx, p1by, downAx[i], downAy[i])) {
                p1Score += 100;
                p1bx = -100; 
                p1by = -100;
                downAy[i] = -70 - (int)(Math.random() * 300);
                downAx[i] = (int)(Math.random() * 730);
            }
        }

        for (int i = 0; i < activeAsteroids; i++) {
            if (hitAsteroid(p2bx, p2by, upAx[i], upAy[i])) {
                p2Score += 100;
                p2bx = -100;
                p2by = -100;
                upAy[i] = 600 + (int)(Math.random() * 300);
                upAx[i] = (int)(Math.random() * 730);
            }
        }

        for (int i = 0; i < activeAsteroids; i++) {
            if (asteroidHitsPlayer(downAx[i], downAy[i], p1x, p1y)) {
                p1Lives--;
                downAy[i] = -70 - (int)(Math.random() * 300);
                downAx[i] = (int)(Math.random() * 730);
            }
        }

        for (int i = 0; i < activeAsteroids; i++) {
            if (asteroidHitsPlayer(upAx[i], upAy[i], p2x, p2y)) {
                p2Lives--;
                upAy[i] = 600 + (int)(Math.random() * 300);
                upAx[i] = (int)(Math.random() * 730);
            }
        }

        if (p1Lives <= 0) {
            winner = 2;
            gameOver = true;
        }
        if (p2Lives <= 0) {
            winner = 1;
            gameOver = true;
        }
    }

    private boolean hitAsteroid(int bx, int by, int ax, int ay) {
        return bx >= ax && bx <= ax + 70 &&
               by >= ay && by <= ay + 70;
    }

    private boolean asteroidHitsPlayer(int ax, int ay, int px, int py) {
        int centerX = ax + 35;
        return Math.abs(centerX - px) < 40 &&
               py >= ay && py <= ay + 70;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (startScreen) return;

        if (code == KeyEvent.VK_LEFT) p1Left = true;
        if (code == KeyEvent.VK_RIGHT) p1Right = true;

        if (code == KeyEvent.VK_UP) {
            if (p1by <= -30) {
                p1bx = p1x;
                p1by = p1y - 40;
            }
        }

        if (code == KeyEvent.VK_A) p2Left = true;
        if (code == KeyEvent.VK_D) p2Right = true;

        if (code == KeyEvent.VK_W) {
            if (p2by >= 630 || p2by <= -30) {
                p2bx = p2x;
                p2by = p2y + 20;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) p1Left = false;
        if (code == KeyEvent.VK_RIGHT) p1Right = false;

        if (code == KeyEvent.VK_A) p2Left = false;
        if (code == KeyEvent.VK_D) p2Right = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}