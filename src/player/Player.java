package player;

import game.GameObject;
import game.KeyEventPress;
import game.Physics.BoxCollider;
import game.items.CheckItems;
import game.renderer.Renderer;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {

    public boolean immune;
    public Player() {
//        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        renderer =new Renderer("assets/images/players/straight");
        position.set(200,500);
        hitbox = new BoxCollider(this,18,18);
        hp = 5;
        immune = false;
    }


    int count = 0,hp;
    @Override
    public void run() {
        this.move();
        this.limitposition();
        this.fire();
        this.checkImmune();
        this.item();
//        System.out.println(objects.size());
    }

    int renderCout = 0;
    @Override
    public void render(Graphics g){
          if(immune){
            renderCout++;
            if (renderCout%3==0){
            super.render(g);}

          }else super.render(g);
    }
    int immunecount =0;
    private void checkImmune() {
        if(immune){
            immunecount++;
            if (immunecount>120){
                immune = false;
            }
        }else {
            immunecount = 0;
        }


    }

    public void takeDamage(int damage){
          if(!immune){
            hp -= damage;
            if(hp<=0){
                hp = 0;
                this.deactive();
            }else{
                immune = true;
            }}
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
    public void item(){
        count++;
        if(count >50){
            CheckItems items = GameObject.recycle(CheckItems.class);

            count =0;}
    }
    }
