package player;

import game.GameObject;
import game.KeyEventPress;
import game.Physics.BoxCollider;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(200,500);
        hitbox = new BoxCollider(this,image.getWidth(),image.getHeight());
        hp = 1;
    }


    int count = 0,hp;
    @Override
    public void run() {
        this.move();
        this.limitposition();
        this.fire();
//        System.out.println(objects.size());
    }
    public void takeDamage(int damage){
        hp -= damage;
        if(hp<=0){
            hp = 0;
            this.deactive();
        }
    }

    public void move(){
        if(KeyEventPress.isUpPress) {
            position.y-=2;
        }
        if(KeyEventPress.isLeftPress) {
            position.x-=2;
        }
        if(KeyEventPress.isRightPress) {
            position.x+=2;
        }
        if(KeyEventPress.isDownPress) {
            position.y+=2;
        }
    }
    public void limitposition(){
        position.x = Mathx.clamp(position.x, 0, 384 - 32);
        position.y = Mathx.clamp(position.y, 0, 600 - 48);
    }
    public void fire(){
        count++;
        if(KeyEventPress.isFirePress && count > 20) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(Math.toRadians(-90));

            PlayerBullet bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet2.position.set(this.position.x - 10, this.position.y);
            bullet2.velocity.setAngle(Math.toRadians(-100));

            PlayerBullet bullet3 = GameObject.recycle(PlayerBullet.class);
            bullet3.position.set(this.position.x + 10, this.position.y);
            bullet3.velocity.setAngle(Math.toRadians(-80));

            count = 0;
    }}
    }
