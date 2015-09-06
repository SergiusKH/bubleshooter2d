import java.awt.*;

/**
 * Created by sergius on 06.09.15.
 */
public class Menu {

    private int buttonWidth;
    private int buttonHeight;
    private Color color;
    private String text;
    private int transp = 0;
    public static boolean leftMouse;


    public Menu() {
        buttonWidth = 120;
        buttonHeight = 60;
        leftMouse = false;

        color = Color.WHITE;
        text = "PLAY";
    }

    public void update() {
        if (EngineGame.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2 &&
                EngineGame.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2 &&
                EngineGame.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2 &&
                EngineGame.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2) {
            if (leftMouse) {
                EngineGame.state = EngineGame.STATES.PLAY;
            }
            transp = 60;
        }else {
            transp = 0;
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(3));
        g.drawRect(GamePanel.WIDTH / 2 - buttonWidth / 2,
                GamePanel.HEIGHT / 2 - buttonHeight / 2,
                buttonWidth, buttonHeight);
        g.setColor(new Color(255, 255, 255, transp));
        g.fillRect(GamePanel.WIDTH / 2 - buttonWidth / 2,
                GamePanel.HEIGHT / 2 - buttonHeight / 2,
                buttonWidth, buttonHeight);
        g.setStroke(new BasicStroke(1));

        g.setColor(color);
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        long len = (long) g.getFontMetrics().getStringBounds(text, g).getWidth();
        g.drawString(text, (int)(GamePanel.WIDTH / 2 - buttonWidth / 2), (int) (GamePanel.HEIGHT / 2 + buttonHeight / 4));
    }
}
