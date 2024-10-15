package com.example.pumpkin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label textLabel;

    @FXML
    protected void transferButtonAction() {
        textLabel.setText("Welcome to JavaFX Application!");
    }
}
