package com.example.pumpkin.model;

import static com.example.pumpkin.model.Direction.*;

public class NormalDirectionState implements DirectionState {
    Model model;

    public NormalDirectionState(Model model) {
        this.model = model;
    }

    @Override
    public void setUp() {
        if (model.currentDirection != DOWN)
            model.setNewDirection(Direction.UP);
    }

    @Override
    public void setDown() {
        if (model.currentDirection != UP)
            model.setNewDirection(Direction.DOWN);
    }

    @Override
    public void setLeft() {
        if (model.currentDirection != RIGHT)
            model.setNewDirection(Direction.LEFT);
    }

    @Override
    public void setRight() {
        if (model.currentDirection != LEFT)
            model.setNewDirection(Direction.RIGHT);
    }
}
