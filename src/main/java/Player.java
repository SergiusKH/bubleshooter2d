import java.awt.*;

/**
 * Created by sergius on 04.09.15.
 */
public class Player {

    private double x, y;
    private int r;
    private int speed;
    private double dx;
    private double dy;

    private Color color1, color2;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean isFiring;
    private double health;

    public Player() {
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;

        r = 5;

        dx = 0;
        dy = 0;
        speed = 5;

        health = 3;

        color1 = Color.WHITE;

        up = false;
        down = false;
        left = false;
        right = false;
        isFiring = false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public void update() {
        if (up && y > r) {
            dy = -speed;
        }
        if (down && y < GamePanel.HEIGHT -r) {
            dy = speed;
        }
        if (left && x > r) {
            dx = -speed;
        }
        if (right && x < GamePanel.WIDTH -r) {
            dx = speed;
        }

        if (up && left || up && right || down && left || down && right) {
            double angle = Math.toRadians(45);
            dx = dx * Math.cos(angle);
            dy = dy * Math.sin(angle);
        }

        y += dy;
        x += dx;

        dy = 0;
        dx = 0;

        if (isFiring) {
            EngineGame.bullets.add(new Bullet());
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(color1);
        g.fillOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color1.darker());
        g.fillOval((int) (x - r), (int) (y - r), 2 * r, 2 * r);
        g.setStroke(new BasicStroke(1));
    }

    public void hit() {
        health--;
        System.out.println(health);
    }
}
