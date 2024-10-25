package com.example.pumpkin.controller;

import com.example.pumpkin.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    public Button sendButton;
    public TextField textField;

    private Model model = new Model();

    //This method will run after the controller object is created
    //and the fields are initialized.

    public void initialize() {
        textField.textProperty().bindBidirectional(model.userTextProperty());
    }

    public Model getModel() {
        return model;
    }

    public void sendAction(ActionEvent actionEvent) {
        model.sendMessage();
    }
}
