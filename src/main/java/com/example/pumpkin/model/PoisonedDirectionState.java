package com.example.pumpkin.model;

import static com.example.pumpkin.model.Direction.*;

public class PoisonedDirectionState implements DirectionState {

    Model model;

    public PoisonedDirectionState(Model model) {
        this.model = model;
    }

    @Override
    public void setUp() {
        if (model.currentDirection != UP)
            model.setNewDirection(Direction.DOWN);
    }

    @Override
    public void setDown() {
        if (model.currentDirection != DOWN)
            model.setNewDirection(Direction.UP);
    }

    @Override
    public void setLeft() {
        if (model.currentDirection != LEFT)
            model.setNewDirection(Direction.RIGHT);
    }

    @Override
    public void setRight() {
        if (model.currentDirection != RIGHT)
            model.setNewDirection(LEFT);
    }
}
