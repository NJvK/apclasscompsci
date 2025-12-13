import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Game {

    private Drawings d;
    private Backgrounds bg;

    // game states
    private boolean onStartScreen = true;
    private boolean onEndScreen = false;

    // rounds
    private int round = 1; // 1..3
    private int p1RoundsWon = 0;
    private int p2RoundsWon = 0;

    // timing
    private long roundStartMs = 0;
    private boolean showingRoundText = false;
    private long roundTextStartMs = 0;

    private static final int ROUND_LENGTH_MS = 10000;   // 10 seconds per round
    private static final int ROUND_TEXT_MS = 2000;      // 2 seconds between rounds

    // scores for current round
    private int p1Score = 0;
    private int p2Score = 0;

    // totals for end stats
    private int p1TotalScore = 0;
    private int p2TotalScore = 0;

    // player positions
    private int p1x = 350;
    private final int p1y = 520;

    private int p2x = 350;
    private final int p2y = 80;

    // movement flags
    private boolean p1Left, p1Right;
    private boolean p2Left, p2Right;

    private final int playerSpeed = 12;

    // bullets
    private int p1bx = -100;
    private int p1by = -100;
    private int p2bx = -100;
    private int p2by = -100;

    private final int bulletSpeed = 18;

    // asteroids
    private static final int MAX_ASTEROIDS = 5;
    private Asteroid[] downAsteroids = new Asteroid[MAX_ASTEROIDS]; // affects Player 1
    private Asteroid[] upAsteroids = new Asteroid[MAX_ASTEROIDS];   // affects Player 2
    private int activeAsteroids = 2; // changes by round

    // winner
    private int winner = 0; // 1 or 2

    public Game() {
        d = new Drawings();
        bg = new Backgrounds();

        initAsteroidsForNewRound();
        showRoundIntro(); // when game starts, we’ll show round intro after start screen
    }

    public void update() {
        if (onStartScreen || onEndScreen) return;

        // Between-round text pause
        if (showingRoundText) {
            if (System.currentTimeMillis() - roundTextStartMs >= ROUND_TEXT_MS) {
                showingRoundText = false;
                roundStartMs = System.currentTimeMillis();
            }
            return;
        }

        // round timer
        if (System.currentTimeMillis() - roundStartMs >= ROUND_LENGTH_MS) {
            endRoundAndAdvance();
            return;
        }

        updatePlayers();
        updateBullets();
        updateAsteroids();
        checkCollisions();
    }

    public void draw(Graphics g) {
        if (onStartScreen) {
            drawStartScreen(g);
            return;
        }

        if (onEndScreen) {
            drawEndScreen(g);
            return;
        }

        // background by round (required: different background per round)
        if (round == 1) bg.drawBackground1(g);
        else if (round == 2) bg.drawBackground2(g);
        else bg.drawBackground3(g);

        if (showingRoundText) {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 34));
            g.drawString("Round " + round, 320, 300);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Get ready...", 350, 340);
            drawHUD(g);
            return;
        }

        // draw players
        d.player1(g, p1x, p1y);
        d.player2(g, p2x, p2y);

        // draw bullets
        if (p1by > -20 && p1by < 620) d.p1bullet(g, p1bx, p1by);
        if (p2by > -20 && p2by < 620) d.p2bullet(g, p2bx, p2by);

        // draw asteroids
        for (int i = 0; i < activeAsteroids; i++) {
            d.asteroid(g, downAsteroids[i].getX(), downAsteroids[i].getY());
            d.asteroid(g, upAsteroids[i].getX(), upAsteroids[i].getY());
        }

        drawHUD(g);
    }

    private void drawStartScreen(Graphics g) {
        d.startScreen(g);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Instructions:", 40, 80);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Player 1 (BOTTOM): Arrow keys move, UP shoots upward", 40, 110);
        g.drawString("Player 2 (TOP): A/D move, W shoots downward", 40, 135);
        g.drawString("Shoot YOUR direction asteroids for +100 points.", 40, 160);
        g.drawString("3 rounds. Each round is 10 seconds. First to win 2 rounds wins.", 40, 185);
        g.drawString("Cheat key: press 9 to skip to next round / end for demo.", 40, 210);

        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Press SPACE to start", 310, 520);
    }

    private void drawEndScreen(Graphics g) {
        // use your existing end screens
        if (winner == 1) d.endScreen1(g);
        else d.endScreen2(g);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Final Stats:", 330, 360);

        g.setFont(new Font("Arial", Font.PLAIN, 16));
        g.drawString("Player 1 total score: " + p1TotalScore, 300, 390);
        g.drawString("Player 2 total score: " + p2TotalScore, 300, 415);
        g.drawString("Rounds won - P1: " + p1RoundsWon + "   P2: " + p2RoundsWon, 270, 440);
    }

    private void drawHUD(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Round: " + round + " (10s)", 15, 20);
        g.drawString("Rounds Won - P1: " + p1RoundsWon + "  P2: " + p2RoundsWon, 15, 40);
        g.drawString("P1 Score: " + p1Score, 15, 60);
        g.drawString("P2 Score: " + p2Score, 680, 60);
        g.drawString("Press 9 to skip round", 15, 80);
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
            downAsteroids[i].update();
            upAsteroids[i].update();

            if (downAsteroids[i].isOffScreen()) {
                downAsteroids[i].reset(randX(), randAbove());
            }
            if (upAsteroids[i].isOffScreen()) {
                upAsteroids[i].reset(randX(), randBelow());
            }
        }
    }

    private void checkCollisions() {
        Rectangle p1Bullet = new Rectangle(p1bx, p1by, 7, 15);
        Rectangle p2Bullet = new Rectangle(p2bx, p2by, 7, 15);

        Rectangle p1Ship = new Rectangle(p1x - 33, p1y, 66, 50);
        Rectangle p2Ship = new Rectangle(p2x - 33, p2y - 50, 66, 50);

        for (int i = 0; i < activeAsteroids; i++) {
            Rectangle downA = downAsteroids[i].getRect();
            Rectangle upA = upAsteroids[i].getRect();

            // P1 bullet hits DOWN asteroid
            if (p1Bullet.intersects(downA)) {
                p1Score += 100;
                p1bx = -100; p1by = -100;
                downAsteroids[i].reset(randX(), randAbove());
            }

            // P2 bullet hits UP asteroid
            if (p2Bullet.intersects(upA)) {
                p2Score += 100;
                p2bx = -100; p2by = -100;
                upAsteroids[i].reset(randX(), randBelow());
            }

            // DOWN asteroid hits Player 1 ONLY
            if (downA.intersects(p1Ship)) {
                downAsteroids[i].reset(randX(), randAbove());
            }

            // UP asteroid hits Player 2 ONLY
            if (upA.intersects(p2Ship)) {
                upAsteroids[i].reset(randX(), randBelow());
            }
        }
    }

    private void endRoundAndAdvance() {
        // decide who won this round by score
        if (p1Score > p2Score) p1RoundsWon++;
        else if (p2Score > p1Score) p2RoundsWon++;
        else {
            // tie breaker: nobody gets a point (or pick one)
            // leaving it as no round point keeps it fair
        }

        p1TotalScore += p1Score;
        p2TotalScore += p2Score;

        // if someone wins 2 rounds, end early
        if (p1RoundsWon == 2) {
            winner = 1;
            onEndScreen = true;
            return;
        }
        if (p2RoundsWon == 2) {
            winner = 2;
            onEndScreen = true;
            return;
        }

        // if round 3 finished, end game
        if (round == 3) {
            if (p1RoundsWon > p2RoundsWon) winner = 1;
            else if (p2RoundsWon > p1RoundsWon) winner = 2;
            else {
                // tie-break by total score
                if (p1TotalScore >= p2TotalScore) winner = 1;
                else winner = 2;
            }
            onEndScreen = true;
            return;
        }

        // otherwise go next round
        round++;
        resetRoundState();
        initAsteroidsForNewRound();
        showRoundIntro();
    }

    private void resetRoundState() {
        p1Score = 0;
        p2Score = 0;

        p1bx = -100; p1by = -100;
        p2bx = -100; p2by = -100;

        p1x = 350;
        p2x = 350;
    }

    private void initAsteroidsForNewRound() {
        // difficulty per round (this also satisfies “levels”: easy then harder)
        if (round == 1) activeAsteroids = 2;
        else if (round == 2) activeAsteroids = 3;
        else activeAsteroids = 5;

        for (int i = 0; i < MAX_ASTEROIDS; i++) {
            downAsteroids[i] = new Asteroid(true, randX(), randAbove(), 5);
            upAsteroids[i] = new Asteroid(false, randX(), randBelow(), 5);
        }
    }

    private void showRoundIntro() {
        showingRoundText = true;
        roundTextStartMs = System.currentTimeMillis();
    }

    private int randX() {
        return (int)(Math.random() * 730);
    }

    private int randAbove() {
        return -70 - (int)(Math.random() * 400);
    }

    private int randBelow() {
        return 600 + (int)(Math.random() * 400);
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (onStartScreen) {
            if (code == KeyEvent.VK_SPACE) {
                onStartScreen = false;
                round = 1;
                p1RoundsWon = 0;
                p2RoundsWon = 0;
                p1TotalScore = 0;
                p2TotalScore = 0;

                resetRoundState();
                initAsteroidsForNewRound();
                showRoundIntro();
            }
            return;
        }

        if (onEndScreen) return;

        // cheat key required: '9'
        if (code == KeyEvent.VK_9) {
            if (round < 3) {
                endRoundAndAdvance();
            } else {
                // force end screen for demo
                if (p1RoundsWon > p2RoundsWon) winner = 1;
                else if (p2RoundsWon > p1RoundsWon) winner = 2;
                else winner = (p1TotalScore >= p2TotalScore) ? 1 : 2;
                onEndScreen = true;
            }
            return;
        }

        if (showingRoundText) return;

        // Player 1: arrows + UP shoot
        if (code == KeyEvent.VK_LEFT) p1Left = true;
        if (code == KeyEvent.VK_RIGHT) p1Right = true;
        if (code == KeyEvent.VK_UP) {
            if (p1by <= -30) {
                p1bx = p1x;
                p1by = p1y - 40;
            }
        }

        // Player 2: A/D + W shoot
        if (code == KeyEvent.VK_A) p2Left = true;
        if (code == KeyEvent.VK_D) p2Right = true;
        if (code == KeyEvent.VK_W) {
            if (p2by >= 630 || p2by <= -30) {
                p2bx = p2x;
                p2by = p2y + 20;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) p1Left = false;
        if (code == KeyEvent.VK_RIGHT) p1Right = false;

        if (code == KeyEvent.VK_A) p2Left = false;
        if (code == KeyEvent.VK_D) p2Right = false;
    }
}