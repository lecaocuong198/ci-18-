package game.items;

import game.GameObject;
import game.Physics.BoxCollider;
import game.renderer.Renderer;

public class CheckItems extends GameObject {
    public CheckItems() {
//        image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        renderer = new Renderer("assets/images/items/power-up-blue.png");
        velocity.set(0, -6);
        position.set(0,-50);
        position.set(0,-3);
        hitbox = new BoxCollider(this, 18, 18);
    }
    @Override
    public void run() {
        // bay tu duoi len
        super.run();
        this.deactiveIfNeeded();
    }
    private void deactiveIfNeeded(){
        if(position.y>600){
            this.deactive();
        }
    }
}
