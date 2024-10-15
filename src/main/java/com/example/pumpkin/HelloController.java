package com.example.pumpkin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class HelloController {

    Model model = new Model();

    public Button transferButton;

    public TextField textField;

    public Label textLabel;

    @FXML
    protected void transferButtonAction() {
        model.setUserText(textField.getText());

        textLabel.setText(model.getUserText());
    }

    public void textFieldChanged(KeyEvent inputMethodEvent) {
        transferButton.setDisable(textField.getText().isEmpty());
    }
}
