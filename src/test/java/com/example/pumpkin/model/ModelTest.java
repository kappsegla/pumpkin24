package com.example.pumpkin.model;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {

    Model model = new Model();

    @Test
    void whenCreatingModelThenGameStateIsPaused() {
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

        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertEquals(new Point(310, 290), result.getFirst()));
    }

    @Test
    @DisplayName("When turning left update should move snake head one position left")
    void whenTurningLeftUpdateShouldMoveSnakeHeadOnePositionLeft() {
        model.pauseUnpause();
        model.setLeft();
        model.update();

        var result = model.getSnake();

        assertThat(result)
                .as(() -> "Head should be at " + new Point(290, 310))
                .contains(new Point(290, 310), Index.atIndex(0))
                .as("Size should be 3")
                .hasSize(3);
    }

    @Test
    @DisplayName("Changing direction multiple times between call to update gets snake to eat itself")
    void changingDirectionMultipleTimesBetweenCallToUpdateGetsSnakeToEatItself() {
        model.pauseUnpause();
        model.setLeft();
        model.setDown();

        assertThat(model.getCurrentDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("AfterEatingPoisonousAppleThenSnakeBecomesPoisoned")
    void afterEatingPoisonousAppleThenSnakeBecomesPoisoned() {
        model.pauseUnpause();
        model.apple = new Apple(new Point(310, 290), true);
        model.update();
        assertThat(model.isPoisoned()).isTrue();
    }

    @Test
    @DisplayName("AfterEatingPoisonousAppleThenControllsBecomesInverted")
    void afterEatingPoisonousAppleThenControllsBecomesInverted() {
        Point expectedHeadPosition = new Point(330, 290);

        model.pauseUnpause();
        model.apple = new Apple(new Point(310, 290), true);
        model.update();
        model.setLeft();
        model.update();

        assertThat(model.getSnake())
                .as(() -> "Head should be at " + expectedHeadPosition)
                .contains(expectedHeadPosition, Index.atIndex(0))
                .as("Size should be 4")
                .hasSize(4);
    }

    @Test
    @DisplayName("Poisonous apple becomes normal after 20 updates")
    void poisonousAppleBecomesNormalAfter20Updates() {
        model.pauseUnpause();
        model.apple = new Apple(new Point(310, 290), true);
        for (int i = 0; i < 10; i++) {
            model.update();
        }
        model.setLeft();
        for (int i = 0; i < 10; i++) {
            model.update();
        }
        assertThat(model.isApplePoisonous()).isFalse();
    }
}
