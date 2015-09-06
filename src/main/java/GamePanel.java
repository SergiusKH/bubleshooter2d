import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by sergius on 03.09.15.
 */
public class GamePanel extends JPanel{

    // Game display
    public static int WIDTH = 600;
    public static int HEIGHT = 600;
    private Cursor cursor;

    public GamePanel() {
        super();
        setFocusable(true);
        requestFocus();
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
        addMouseListener(new Listeners());

        Toolkit kit = Toolkit.getDefaultToolkit();
        BufferedImage buffered = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = (Graphics2D) buffered.getGraphics();
        graphics2D.setColor(new Color(255, 255, 255));
        graphics2D.drawOval(0, 0, 4, 4);
        graphics2D.drawLine(2, 0, 2, 4);
        graphics2D.drawLine(0, 2, 4, 2);
        cursor = kit.createCustomCursor(buffered, new Point(3, 3), "mycursor");
        graphics2D.dispose();

        this.setCursor(cursor);
    }
}
