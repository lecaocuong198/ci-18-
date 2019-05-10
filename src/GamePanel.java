import tklibs.Mathx;
import tklibs.SpriteUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
//    BufferedImage backGroundImage;
//    BufferedImage playerImage;
    Background background;
    Player player;

//    int backGroudHeight;
//    int playerX =  150;
//    int playerY = 600 ;
    vector2d playerposition;

    public GamePanel() {
//        backGroundImage = SpriteUtils.loadImage("assets/images/scenes/background.png");
//        playerposition = new vector2d(200,500);
//        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        backGroudHeight = backGroundImage.getHeight()*-1+700;
        background = new Background();
        player = new Player();
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.drawImage(backGroundImage, 0, backGroudHeight, null);
        background.render(g);
        player.render(g);
    }



    public void gameloop() {
        long lasttime = 0;
        while (true) {
//            long currenTime = System.currentTimeMillis();
            long currenTime = System.nanoTime();
            if ((currenTime - lasttime > 1000000000 / 60)) {
//                System.out.println(currenTime-lasttime);
                //logic
                    this.runAll();
                    //render
                    this.repaint();
                    lasttime = currenTime;
            }
        }
    }
    public void runAll(){

        player.run();

        background.run();

    }
}
