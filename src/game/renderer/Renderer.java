package game.renderer;

import game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currenImageIndex;
    public int frameCount;


    public Renderer(String url){
        File source = new File((url));
        if(source.exists()&& source.isFile()){
            image = SpriteUtils.loadImage(url);
        }
        if (source.exists()&&source.isDirectory()){
            images = SpriteUtils.loadImages(url);
        }
        currenImageIndex = 0;
        frameCount = 0;
    }
    public void render(Graphics g, GameObject master){
        if(image !=null ){

            g.drawImage(image,(int) master.position.x,(int) master.position.y,null);
        }
        if (images!=null){
            BufferedImage currenImage = images.get(currenImageIndex);
            g.drawImage(currenImage, (int) master.position.x, (int)master.position.y,null);
        frameCount++;
        if(frameCount>6){
            currenImageIndex++;
            if(currenImageIndex >=images.size()){
                currenImageIndex = 0;
            }frameCount = 0;
        }
        }
    }
}
