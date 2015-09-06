import java.awt.*;

/**
 * Created by sergius on 03.09.15.
 */
public class GameBack {

    private Color color;

    public GameBack() {
        color = Color.BLUE;
    }

    public void update() {

    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);

    }
}
