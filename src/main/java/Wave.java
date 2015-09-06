import java.awt.*;

/**
 * Created by sergius on 05.09.15.
 */
public class Wave {


    private int waveNumber, waveMultiplier;
    private String waveText;

    private long waveTimer, waveDelay, waveTimerDiff;

    public Wave() {
        waveNumber = 1;
        waveMultiplier = 10;

        waveTimer = 0;
        waveDelay = 5000;
        waveTimerDiff = 0;

        waveText = " В О Л Н А ";
    }

    public void update() {
        if (EngineGame.enemies.size() == 0 && waveTimer == 0) {
            waveTimer = System.nanoTime();

        }

        if (waveTimer > 0) {
            waveTimerDiff += (System.nanoTime() - waveTimer) / 1000000;
            waveTimer = System.nanoTime();
        }

        if (waveTimerDiff > waveDelay) {
            createEnemies();
            waveTimer = 0;
            waveTimerDiff = 0;
        }
    }

    private void createEnemies() {
        int enemyCount = waveMultiplier * waveNumber;
        if (waveNumber < 5) {
            while (enemyCount > 0) {
                int rank = 1;
                int type = 1;
                EngineGame.enemies.add(new Enemy(type, rank));
                enemyCount -= type * rank;
            }

        }
        waveNumber++;
        if (waveNumber == 5) {
            waveNumber = 1;
            EngineGame.state = EngineGame.STATES.MENU;
            System.out.println(waveNumber);
        }
    }

    public boolean showWave() {
        if (waveTimer != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(Graphics2D g) {
        double divider = waveDelay / 180;
        double alpha = waveTimerDiff / divider;
        alpha = 255 * Math.toRadians(alpha);
        if (alpha < 0) alpha = 0;
        if (alpha > 1) alpha = 255;
        g.setFont(new Font("consolas", Font.PLAIN, 20));
        g.setColor(new Color(255, 255, 255, (int)alpha));
        String s = " - " + waveText + " " + waveNumber + " -";
        long len = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        g.drawString(s, GamePanel.WIDTH / 2 - (int) (len / 2), GamePanel.HEIGHT / 2);
    }
}
