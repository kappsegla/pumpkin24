package com.example.pumpkin.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static com.example.pumpkin.model.Direction.UP;

public class Model {
    Point apple;
    //Point head; snake.getFirst()
    List<Point> snake = new ArrayList<>();
    Direction currentDirection = UP;

    public Model(){
        snake.add(new Point(300,300));
        snake.add(new Point(300,320));
        snake.add(new Point(300,340));
    }

    public List<Point> getSnake() {
        return snake;
    }

    public void setUp() {


    }

    public void setDown() {


    }

    public void setLeft() {


    }

    public void setRight() {

    }
}
