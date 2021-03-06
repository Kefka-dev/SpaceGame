package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;



public class Sprite {

    private Image image;
    private double posX;
    private double posY;
    private double velX;
    private double velY;
    private double width;
    private double height;

    public Sprite(){
        posX = 0;
        posY = 0;
        velX = 0;
        velY = 0;
    }

    public void setImage(Image i){
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename){
        Image i = new Image(filename);
        setImage(i);
    }

    public Image getImage(){
        return image;
    }


    public void setPos(double x, double y){
        posX = x;
        posY = y;
    }

    public double getPosX(){
        return posX;
    }

    public double getPosY(){
        return posY;
    }

    public void setVel(double x, double y){
        velX = x;
        velY = y;
    }

    public void addVel(double x, double y){
        velX += x;
        velY += y;
    }

    public void update(double time){
        posX += velX * time;
        posY += velY * time;
    }

    public void render (GraphicsContext gc){
        gc.drawImage(image, posX, posY);
    }

    public Rectangle2D getBoundary(){
        return new Rectangle2D(posX, posY, width, height);
    }

    public boolean intersects(Sprite s){
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String doStringu(){
        return "Position :[" + posX + "," + posY + "]" + " Velocity: [" + velX + "," + velY + "]";
    }
}
