package game.Enemies;

import game.GameObject;
import game.Physics.BoxCollider;
import player.Player;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    int damage;
    public EnemyBullet(){
        image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        velocity.set(0,-6);
        hitbox = new BoxCollider(this,image.getWidth(),image.getHeight());
        damage = 1;
    }
    @Override
    public void run() {
        // bay tu duoi len
        super.run();
        this.deactiveIfNeeded();
        this.checkEnemyb();

    }
    private void checkEnemyb(){
        Player player = GameObject.findIntersects(Player.class,hitbox);
        if(player!=null){
//            enemy.deactive();
            player.takeDamage(damage);
            this.deactive();
        }}

    private void deactiveIfNeeded(){
        if(position.y<-30){
            this.deactive();
        }
    }

}
