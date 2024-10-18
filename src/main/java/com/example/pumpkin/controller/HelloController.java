package com.example.pumpkin.controller;

import com.example.pumpkin.model.Model;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HelloController {

    public Canvas canvas;

    //This method will run after the controller object is created
    //and the fields are initialized.
    public void initialize() {
        startRandomEvent();
        canvas.getGraphicsContext2D().fillText("Press Space to start playing",200,300);
    }

    private void startRandomEvent(){
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(300),
                        (ActionEvent event) -> {
                            gameUpdate();
                            startRandomEvent();
                        }
                )
        );
        timeline.play();
    }

    public void keyPressed(KeyEvent keyEvent) {
        //Call methods on model to update snake direction
        switch (keyEvent.getCode()) {
            case UP, W -> model.setUp();
            case DOWN, S -> model.setDown();
            case LEFT, A -> model.setLeft();
            case RIGHT, D -> model.setRight();
            case SPACE -> model.pauseUnpause();
        }
    }

    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void gameUpdate() {
        model.update();

        var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //This information will come from our model!
        gc.setFill(Color.GREEN);
        model.getSnake().forEach(point -> {
            gc.fillRect(point.x() - 10,point.y() - 10, 20, 20);
        });
        gc.setFill(Color.RED);
        gc.fillOval(model.getApple().x() - 10,model.getApple().y() - 10, 20, 20);
    }
}
