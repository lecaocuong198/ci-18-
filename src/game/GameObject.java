package game;

import game.Physics.BoxCollider;
import player.Player;
import player.PlayerBullet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static <E extends GameObject> E recycle(Class<E> cls){
        //1.Tim phan tu bi deactive >> reset phan tu >> tra ve
        //2.Neu k tim thay phan tu bi deactive >> tao moi>> tra ve
        E object = findIactive(cls);
        if(object != null){
            object.reset();
            return object;
        }else {
            try{object = cls.getConstructor().newInstance();
                return object;}
            catch (Exception ex){
                return null;
            }

        }
    }
    public static <E extends GameObject> E findIactive(Class<E> cls){
        //cls ~ Player.class || Background.class..
        //E ~ Player ||Background..

        for(int i =0;i<objects.size();i++){
            GameObject object = objects.get(i);
            //object ~ cls
            //object.active == false
            if(cls.isAssignableFrom(object.getClass())&& !object.active){
                return (E)object;
            }
        }
        return null;
    }
    public static <E extends GameObject> E findIntersects(Class<E> cls,BoxCollider hitbox){
        for (int i = 0; i < objects.size() ; i++) {
            GameObject object = objects.get(i);
            //1.active
            //2.object ~cls
            //3.object.hitbox!null && object.hitbox.intersects(hitbox)
            if(object.active
                    && cls.isAssignableFrom(object.getClass())
                    && object.hitbox.intersects(hitbox) )
            {
                return (E) object;
            }
        }return null;
    }




    public Vector2D velocity;
    public BufferedImage image;
    public Vector2D position;
    public boolean active;
    public BoxCollider hitbox;



    public GameObject(){
        objects.add(this);
        velocity = new Vector2D();
        position = new Vector2D();
        active = true;
    }

    public void render(Graphics g){
        if(image!=null){
            g.drawImage(image,(int) position.x,(int)position.y,null);
        }
    }

    public void run(){
        position.add(velocity.x,velocity.y);
    }


    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }
}
