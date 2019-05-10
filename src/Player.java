import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {
    BufferedImage image;
    vector2d position;
    ArrayList<PlayerBullet> playerBullet;

    public Player(){
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new vector2d(200,500);
        playerBullet = new ArrayList<>();

    }

    public void render(Graphics g){
        g.drawImage(image,(int) position.x,(int) position.y,null);
        for(int i = 0;i<playerBullet.size();i++){
            PlayerBullet bullet = playerBullet.get(i);
            bullet.render(g);
        }
    }
    int cout = 0;
    public void run(){
        if(KeyEvenPress.isUpPress == true){
            position.y-=2;
        }
        if(KeyEvenPress.isDownPress == true){
            position.y+=2;
        }
        if(KeyEvenPress.isLeftPress == true){
            position.x-=2;
        }
        if(KeyEvenPress.isRightPress== true){
            position.x+=2;
        }
        position.x = Mathx.clamp(position.x,0,384-32);
        position.y = Mathx.clamp(position.y,0,600-48);
        cout ++;
        if(KeyEvenPress.isFirePress && cout >20){
            PlayerBullet bullet = new PlayerBullet();
            bullet.position.set(this.position.x,this.position.y);
            bullet.position2.set(this.position.x,this.position.y);
            bullet.position3.set(this.position.x,this.position.y);
            playerBullet.add(bullet);
            cout =0;
        }
        for(int i =0;i<playerBullet.size();i++){
            PlayerBullet bullet = playerBullet.get(i);
            bullet.run();
        }
    }

}
