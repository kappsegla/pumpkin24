package com.example.pumpkin.controller;

import com.example.pumpkin.model.Model;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    public Canvas canvas;

    List<Color> colors = new ArrayList<>();
    int index = 0;

    //This method will run after the controller object is created
    //and the fields are initialized.
    public void initialize() {
        colors.add(Color.BLACK);
        colors.add(Color.RED);
        colors.add(Color.GREEN);

    }

    public void keyPressed(KeyEvent keyEvent) {
        //Call methods on model to update snake direction
        switch (keyEvent.getCode()) {
            case UP, W -> model.setUp();
            case DOWN, S -> model.setDown();
            case LEFT, A -> model.setLeft();
            case RIGHT, D -> model.setRight();
        }
    }

    private Model model = new Model();

    public Model getModel() {
        return model;
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();

        var gc = canvas.getGraphicsContext2D();
        //Random color
        //gc.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        //Pick next color from list of colors
//        gc.setFill(colors.get(index++));
//        if( index >= colors.size() ) {
//            index = 0;
//        }

        //This information will come from our model!
        gc.setFill(Color.GREEN);
        gc.fillRect(x - 10, y - 10, 20, 20);

        gc.setFill(Color.RED);
        gc.fillOval(100 - 10, 100 - 10, 20, 20);


    }
}
