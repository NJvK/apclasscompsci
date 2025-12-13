import java.awt.Rectangle;

public class Asteroid {
    private int x;
    private int y;
    private int dy;
    private boolean movingDown;

    public Asteroid(boolean movingDown, int startX, int startY, int speed) {
        this.movingDown = movingDown;
        this.x = startX;
        this.y = startY;
        this.dy = speed;
    }

    public void update() {
        if (movingDown) y += dy;
        else y -= dy;
    }

    public void reset(int newX, int newY) {
        x = newX;
        y = newY;
    }

    public boolean isOffScreen() {
        if (movingDown) return y > 620;
        return y < -80;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, 70, 70);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}