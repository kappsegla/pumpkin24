package com.example.pumpkin.model;

import java.util.ArrayList;
import java.util.List;

import static com.example.pumpkin.model.Direction.*;
import static com.example.pumpkin.model.GameState.*;

public class Model {
    Point apple;
    //Point head; snake.getFirst()
    List<Point> snake = new ArrayList<>();
    Direction currentDirection = UP;
    GameState gameState = RUNNING;

    public Model() {
        snake.add(new Point(300, 300));
        snake.add(new Point(300, 320));
        snake.add(new Point(300, 340));
    }

    public List<Point> getSnake() {
        return snake;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setUp() {
        if (currentDirection != DOWN)
            currentDirection = UP;
    }

    public void setDown() {
        if (currentDirection != UP)
            currentDirection = DOWN;
    }

    public void setLeft() {
        if (currentDirection != RIGHT)
            currentDirection = LEFT;
    }

    public void setRight() {
        if (currentDirection != LEFT)
            currentDirection = RIGHT;
    }
}
