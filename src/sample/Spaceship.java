package sample;

import java.util.ArrayList;

public class Spaceship extends Sprite{

    public void move(Spaceship obj, ArrayList<String> i){
        if (i.contains("LEFT")){
            obj.addVel(-200,0);
            obj.setImage("Assets/bgbattleship_left.png");
        }

        if (i.contains("RIGHT")){
            obj.addVel(200,0);
            obj.setImage("Assets/bgbattleship_right.png");
        }

        if (i.contains("UP")){
            obj.addVel(0,-200);
            obj.setImage("Assets/bgbattleship.png");
        }

        if (i.contains("RIGHT") && i.contains("UP")) {
            obj.setImage("Assets/bgbattleship_top-right.png");
        }

        if (i.contains("LEFT") && i.contains("UP")) {
            obj.setImage("Assets/bgbattleship_top-left.png");
        }

        if (i.contains("DOWN")){
            obj.addVel(0,200);
            obj.setImage("Assets/bgbattleship_down.png");
        }

        if (i.contains("RIGHT") && i.contains("DOWN")) {
            obj.setImage("Assets/bgbattleship_down-right.png");
        }

        if (i.contains("LEFT") && i.contains("DOWN")) {
            obj.setImage("Assets/bgbattleship_down-left.png");
        }

    }

}
