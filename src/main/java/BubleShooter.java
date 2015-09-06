import javax.swing.*;
import java.awt.*;

/**
 * Created by sergius on 03.09.15.
 */
public class BubleShooter extends JFrame {

    public BubleShooter(GamePanel gamePanel) {
        super();
        this.setTitle(this.getClass().getSimpleName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension displaySize = toolkit.getScreenSize();
        // Display location center
        this.setLocation(displaySize.width / 2 - GamePanel.WIDTH / 2, displaySize.height / 2 - GamePanel.HEIGHT / 2);
        this.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
        this.setVisible(true);
        this.add(gamePanel);
        new Thread(new EngineGame(gamePanel)).start();
    }

}
