package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Input{



    public ArrayList<String> getInput(Scene theScene){
        ArrayList<String> input = new ArrayList<String>();
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        String code = keyEvent.getCode().toString();

                        if (!input.contains(code)) {
                            input.add(code);
                        }
                    }
                }
        );

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        String code = keyEvent.getCode().toString();
                        input.remove(code);
                    }
                }
        );

        return (input);
    }



}


