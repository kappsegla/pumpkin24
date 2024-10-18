package com.example.pumpkin.model;

import java.util.ArrayList;
import java.util.List;

import static com.example.pumpkin.model.Direction.*;
import static com.example.pumpkin.model.GameState.*;

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

    public void update(){
        //Beräkna ny position för ormen
        Point next = calculateNextHeadPos();
        //Kolla om ormen kolliderar med sig själv?
        checkForCollisionWithSelf(next);
        //Kolla om ormen kolliderar med vägg?
        checkForCollisionWithWalls(next);
        //Kolla kolliderar med äpple
        checkForCollisionWithApple(next);
        //Spara ny position
        snake.addFirst(next);
    }

    private void checkForCollisionWithApple(Point next) {

    }

    private void checkForCollisionWithWalls(Point next) {

    }

    private void checkForCollisionWithSelf(Point next) {

    }

    private Point calculateNextHeadPos() {
        return null;
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
