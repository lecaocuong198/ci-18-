package game.Enemies;

import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;
import tklibs.SpriteUtils;

public class Enemies extends GameObject {
    public int hp;
    public Enemies(){
//        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
        renderer = new Renderer("assets/images/enemies/level0/black");
        position.set(0,-50);
        velocity.set(0,-3);
        velocity.setAngle(Math.toRadians(30));
        hitbox = new BoxCollider(this,20,20);
        hp = 3;
    }
    public void takeDamage(int damage){
        hp -= damage;
        if(hp<=0){
            hp = 0;
            this.deactive();
        }
    }
    int count =0;
    public void fire(){
        count++;
        if(count >20){
        EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
        bullet.position.set(this.position.x, this.position.y);
        bullet.velocity.setAngle(Math.toRadians(90));
        count =0;}
    }

    @Override
    public void run(){
        super.run();
        if(this.onGoingRight() && this.outOfBoundRight()){
            this.reverseVelocityX();
        }
        if(this.onGoingLeft() && this.outOfBoundLeft()){
            this.reverseVelocityX();
        }
        this.deactiveIfNeeded();
        this.fire();
    }
    @Override
    public void reset(){
        super.reset();
        position.set(0,-50);
        velocity.set(0,-3);
        velocity.setAngle(Math.toRadians(30));
        hp = 3;
    }

    private void deactiveIfNeeded(){
        if (position.y>600){
            this.deactive();
        }
    }

    private void reverseVelocityX(){
        velocity.x*=-1;
    }
    private boolean outOfBoundRight(){
        return position.x>384-32;
    }
    private boolean onGoingRight(){
        return velocity.x>0;
    }
    private boolean onGoingLeft(){
        return position.x<0;
    }
    private boolean outOfBoundLeft(){
        return velocity.x<0;
    }

}
