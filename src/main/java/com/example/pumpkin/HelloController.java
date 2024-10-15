package com.example.pumpkin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class HelloController {

    public Button topButton;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void topButtonMouseEnter(MouseEvent mouseEvent) {
        topButton.setText("Mouse entered");
    }

    public void topButtonMouseLeave(MouseEvent mouseEvent) {
        topButton.setText("Mouse exited");
    }
}
