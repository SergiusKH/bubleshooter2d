import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by sergius on 03.09.15.
 */
public class EngineGame implements Runnable {

    private final GamePanel gamePanel;

    private BufferedImage image;
    private Graphics2D g;

    public static GameBack background;
    public static Player player;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static Wave wave;
    public static Menu menu;

    private int FPS;
    private int timerFPS;
    private double milliisToFPS;
    private int sleepTime;

    public static int mouseX;
    public static int mouseY;

    public static enum STATES {
        MENU,
        PLAY
    }

    public static STATES state = STATES.MENU;

    public EngineGame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void run() {

        FPS = 30;
        milliisToFPS = 1000 / FPS;
        sleepTime = 0;

        image = new BufferedImage(GamePanel.WIDTH, GamePanel.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        background = new GameBack();
        player = new Player();
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();
        wave = new Wave();
        menu = new Menu();

        while (true) {

            timerFPS = (int) System.nanoTime();

            if (state.equals(STATES.MENU)) {
                background.update();
                background.draw(g);
                menu.update();
                menu.draw(g);
                gameDraw();
            }
            if (state.equals(STATES.PLAY)) {
                gameUpdate();
                gameRender();
                gameDraw();

            }

            timerFPS = (int) (System.nanoTime() - timerFPS) / 1000000;
            if (milliisToFPS > timerFPS) {
                sleepTime = (int) (milliisToFPS - timerFPS);
            } else sleepTime = 1;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timerFPS = 0;
            sleepTime = 1;
        }
    }

    private void gameUpdate() {
        background.update();

        player.update();

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            boolean remove = bullets.get(i).remove();
            if (remove) {
                bullets.remove(i);
                i--;
            }

        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();
            for (int j = 0; j < bullets.size(); j++) {
                Bullet b = bullets.get(j);
                double bx = b.getX();
                double by = b.getY();
                double dx = ex - bx;
                double dy = ey = by;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if ((int) dist <= e.getR() + b.getR()) {
                    e.hit();
                    bullets.remove(j);
                    j--;
                    boolean remove = e.remove();
                    if (remove) {
                        enemies.remove(i);
                        i--;
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            double ex = e.getX();
            double ey = e.getY();

            double px = player.getX();
            double py = player.getY();

            double dx = ex - px;
            double dy = ey - py;

            double dist = Math.sqrt(dx * dx + dy * dy);
            if ((int) dist <= e.getR() + player.getR()) {
                e.hit();
                player.hit();
                boolean remove = e.remove();
                if (remove) {
                    enemies.remove(i);
                    i--;
                }

            }
        }
        wave.update();
    }

    private void  gameRender() {
        background.draw(g);

        player.draw(g);

        if (wave.showWave()) {
            wave.draw(g);
        }

        for (Bullet b : bullets) {
            b.draw(g);
        }

        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }

    }

    private void gameDraw() {
        Graphics disp = gamePanel.getGraphics();
        disp.drawImage(image, 0, 0, null);
        disp.dispose();
    }
}

