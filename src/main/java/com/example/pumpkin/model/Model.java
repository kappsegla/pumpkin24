package com.example.pumpkin.model;

import java.util.ArrayList;
import java.util.List;

import static com.example.pumpkin.model.Direction.*;
import static com.example.pumpkin.model.GameState.RUNNING;

public class Model {
    public static final int BOARD_SIZE = 600;
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

    public void update() {
        Point next = calculateNextHeadPos();
        checkForCollisionWithWalls(next);
        checkForCollisionWithApple(next);
        checkForCollisionWithSelf(next);
        //Spara ny position
        snake.addFirst(next);
    }

    private Point calculateNextHeadPos() {
        var currentHead = snake.getFirst();
        return switch (currentDirection) {
            case LEFT -> new Point(currentHead.x() - 20, currentHead.y());
            case RIGHT -> new Point(currentHead.x() + 20, currentHead.y());
            case UP -> new Point(currentHead.x(), currentHead.y() - 20);
            case DOWN -> new Point(currentHead.x(), currentHead.y() + 20);
        };
    }

    private void checkForCollisionWithWalls(Point next) {

    }

    private void checkForCollisionWithSelf(Point next) {

    }

    private void checkForCollisionWithApple(Point next) {

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
