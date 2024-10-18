package com.example.pumpkin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.pumpkin.model.Direction.*;
import static com.example.pumpkin.model.GameState.FINISHED;
import static com.example.pumpkin.model.GameState.RUNNING;

public class Model {
    public static final int BOARD_SIZE = 600;
    Point apple;
    //Point head; snake.getFirst()
    List<Point> snake = new ArrayList<>();
    Direction currentDirection = UP;
    GameState gameState = RUNNING;
    Random random = new Random();

    public Model() {
        snake.add(new Point(310, 310));
        snake.add(new Point(310, 330));
        snake.add(new Point(310, 350));

        apple = randomApple(snake.getFirst());
    }

    public List<Point> getSnake() {
        return snake;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void update() {
        if (gameState != RUNNING) {
            System.out.println(gameState);
            return;
        }
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
        if (next.x() < 10 || next.x() > BOARD_SIZE - 10 ||
            next.y() < 10 || next.y() > BOARD_SIZE - 10) {
            gameState = FINISHED;
        }
    }

    private void checkForCollisionWithSelf(Point next) {
        if (snake.contains(next))  //Compare objects using equals... what happens with double values?????
            gameState = FINISHED;
    }

    private void checkForCollisionWithApple(Point next) {
        if (next.equals(apple))
            apple = randomApple(next);
        else
            snake.removeLast();
    }

    private Point randomApple(Point next) {
        Point newApple;
        do {
            int xPos = random.nextInt(BOARD_SIZE / 20) * 20 + 10;
            int yPos = random.nextInt(BOARD_SIZE / 20) * 20 + 10;
            //10 30 50 70 90 ... 590
            newApple = new Point(xPos, yPos);
        } while (newApple.equals(next) || snake.contains(newApple));
        return newApple;
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

    public Point getApple() {
        return apple;
    }
}
