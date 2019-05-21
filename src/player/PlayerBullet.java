package player;

import game.Enemies.Enemies;
import game.GameObject;
import game.Physics.BoxCollider;
import game.Vector2D;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject { // PlayerBulletType2

    public int damage;
    public PlayerBullet() {
//        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        renderer = new Renderer("assets/images/player-bullets/a");
        velocity.set(0,-6);
        hitbox = new BoxCollider(this,24,24);
        damage = 1;

//        velocity.setAngle(Math.toRadians(-135));
    }

//    public void render(Graphics g) {
//        g.drawImage(image, (int) position.x, (int) position.y, null);
//    }
    @Override
    public void run() {
        // bay tu duoi len
        super.run();
        this.deactiveIfNeeded();
        this.checkEnemy();
    }
    private void checkEnemy(){
        Enemies enemy = GameObject.findIntersects(Enemies.class,hitbox);
        if(enemy!=null){
//            enemy.deactive();
            enemy.takeDamage(damage);
            this.deactive();
        }
    }
    private void deactiveIfNeeded(){
        if(position.y<-30){
            this.deactive();
        }
    }
}
