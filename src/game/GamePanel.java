package game;

import game.Enemies.Enemies;
import game.Enemies.EnemySummoner;
import player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    Enemies enemies;
    // player.PlayerBullet bullet;
    // ArrayList: add(), remove(), size(), get()

    public GamePanel() {
        background = new Background();
        player = new Player();
        EnemySummoner enemy = new EnemySummoner();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        background.render(g);
//        player.render(g)
        for(int i =0;i<GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.render(g);
            }
        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000 / 60) {
                // run logic
                this.runAll();
                // render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
        for(int i =0;i<GameObject.objects.size();i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.run();
            }
        }
        player.run();
        // background run
        background.run();
    }
}
