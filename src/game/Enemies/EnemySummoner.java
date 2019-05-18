package game.Enemies;

import game.GameObject;

public class EnemySummoner extends GameObject {

    public EnemySummoner(){

    }
    int count = 0;
    @Override
    public void run(){
        count++;
        if(count>120){
            Enemies enemy = GameObject.recycle(Enemies.class);
            count = 0;
        }
        System.out.println(GameObject.objects.size());
    }
}

