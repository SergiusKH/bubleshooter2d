import java.awt.*;

/**
 * Created by sergius on 05.09.15.
 */
public class Bullet {

    private double x, y, bulletMouseX, bulletMouseY, distX, distY, dist;
    private int speed, r;
    private Color color;

    public Bullet() {
        x = EngineGame.player.getX();
        y = EngineGame.player.getY();

        speed = 10;
        r = 2;

//        distX = EngineGame.mouseX - x;
//        distY = EngineGame.mouseY - y;
//        dist = Math.sqrt(distX * distX + distY * distY);
//
//        bulletMouseX = distX / dist * speed;
//        bulletMouseY = distY / dist * speed;

        color = Color.WHITE;
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

    public boolean remove() {
        if (y < 0 && y > GamePanel.HEIGHT && x < 0 && x > GamePanel.WIDTH)
            return true;
        return false;
    }

    public void update() {
//        x += distX;
//        y += distY;

        y -= speed;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int)x -r, (int)y -r, r, 2 * r);
    }
}
