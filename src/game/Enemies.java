package game;

import tklibs.SpriteUtils;

public class Enemies extends GameObject {
    public Enemies(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png");
        position.set(100,100);
    }

    @Override
    public void run(){
        if (position.x>20&&position.x<300){
            position.x-=2;}
    }

}
