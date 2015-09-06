import javax.swing.*;
import java.awt.*;

/**
 * Created by sergius on 03.09.15.
 */
public class GameStart {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GamePanel gamePanel = new GamePanel();
                new BubleShooter(gamePanel);
            }
        });
    }

}