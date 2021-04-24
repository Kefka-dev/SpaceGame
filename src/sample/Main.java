package sample;

import com.sun.jdi.LongValue;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
 

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception
    {
        theStage.setTitle("EPIC GEJM");
        theStage.setResizable(false);
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas(800, 600);
        root.getChildren().add( canvas );

        theStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                System.exit(0);
            }
        });


        Input keyboardInput = new Input();
        ArrayList<String> input = keyboardInput.getInput(theScene);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image background = new Image("Assets/Space/PNG/Space_Stars9_rescaled.png");

        Spaceship raketa = new Spaceship();
        raketa.setImage("Assets/bgbattleship.png");
        raketa.setPos(400, 300);

        LongVal lastNanoTime = new LongVal(System.nanoTime());

        new AnimationTimer(){
            public void handle(long currentNanoTime){

                //čas od posledneho update
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;

//                System.out.println(lastNanoTime.value);
//                System.out.println(elapsedTime);
//                double x = 232 + 128 * Math.cos(currentNanoTime);
//                double y = 232 + 128 * Math.sin(currentNanoTime);
//                double xrocket= 400, yrocket=300;

                gc.drawImage(background, 0, 0);

                raketa.setVel(0,0);

                raketa.move(raketa, input);

                raketa.update(elapsedTime);

                //System.out.println(raketa.getPosX() + " " + raketa.getPosY());
                raketa.render(gc);
            }
        }.start();

        theStage.show();
    }

}
