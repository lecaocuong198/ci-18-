import tklibs.SpriteUtils;
import java.awt.*;

import java.awt.image.BufferedImage;

public class Background {

    BufferedImage image;
    vector2d position;
    public Background(){
        image = SpriteUtils.loadImage("assets/images/scenes/background.png");
        position=new vector2d(0,(image.getHeight()*-1+700));

    }
    public void render(Graphics g){
        g.drawImage(image,(int)position.x,(int)position.y,null);
    }
    public void run(){
        position.y+=2;
        if (position.y>=0){
            position.y =0;
        }

    }
}
