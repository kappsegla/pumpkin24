package com.example.pumpkin.model;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = new Model();

    @Test
    void whenCreatingModelThenGameStateIsPaused(){
        assertEquals(GameState.PAUSED, model.getGameState(),
                "Initial game state should be paused.");
    }

    @Test
    @DisplayName("When calling PauseUnPause game state changes to running 😊")
    void whenCallingPauseUnPauseGameStateChangesToRunning() {
        //Arrange
        //Act
        model.pauseUnpause();

        //Assert
        assertEquals(GameState.RUNNING, model.getGameState());
        //Can have more asserts if needed to verify new state.
    }

    @Test
    @DisplayName("When paused calling pauseUnPause twice game state should be paused")
    void whenPausedCallingPauseUnPauseTwiceGameStateShouldBePaused() {
        model.pauseUnpause();
        model.pauseUnpause();

        assertEquals(GameState.PAUSED, model.getGameState());
    }

    @Test
    @DisplayName("When running calling update should move snake one position in current direction")
    void whenRunningCallingUpdateShouldMoveSnakeOnePositionInCurrentDirection() {
        model.pauseUnpause();

        model.update();

        var result = model.getSnake();
        assertEquals(3, result.size());
        assertEquals(new Point(310, 290), result.getFirst());
    }

    @Test
    @DisplayName("When turning left update should move snake head one position left")
    void whenTurningLeftUpdateShouldMoveSnakeHeadOnePositionLeft() {
        model.pauseUnpause();
        model.setLeft();
        model.update();

        var result = model.getSnake();
        assertEquals(3, result.size());
        assertEquals(new Point(290, 310), result.getFirst());
    }

}
