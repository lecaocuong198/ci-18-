package game.Enemies;

import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;
import player.Player;
import tklibs.SpriteUtils;

public class EnemyBullet extends GameObject {
    int damage;
    public EnemyBullet(){
//        image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        renderer = new Renderer("assets/images/enemies/bullets");
        velocity.set(0,-6);
        hitbox = new BoxCollider(this,18,18);
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
        if(position.y>600){
            this.deactive();
        }
    }

}
