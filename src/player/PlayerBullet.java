package player;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject { // PlayerBulletType2

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
    }

//    public void render(Graphics g) {
//        g.drawImage(image, (int) position.x, (int) position.y, null);
//    }
    @Override
    public void run() {
        // bay tu duoi len
        position.y -= 3;
        this.deactiveIfNeeded();
    }
    private void deactiveIfNeeded(){
        if(position.y<-30){
            this.deactive();
        }
    }
}
