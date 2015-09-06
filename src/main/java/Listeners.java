import java.awt.event.*;

/**
 * Created by sergius on 04.09.15.
 */
public class Listeners implements KeyListener, MouseMotionListener, MouseListener{

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = true;
        }
        if (key == KeyEvent.VK_SPACE) {
            Player.isFiring = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            EngineGame.state = EngineGame.STATES.MENU;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = false;
        }
        if (key == KeyEvent.VK_SPACE) {
            Player.isFiring = false;
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Player.isFiring = true;
            Menu.leftMouse = true;
        }

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Player.isFiring = false;
            Menu.leftMouse = false;
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        EngineGame.mouseX = e.getX();
        EngineGame.mouseY = e.getY();

    }

    public void mouseMoved(MouseEvent e) {
        EngineGame.mouseX = e.getX();
        EngineGame.mouseY = e.getY();
    }
}
