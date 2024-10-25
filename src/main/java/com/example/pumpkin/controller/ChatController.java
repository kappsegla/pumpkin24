package com.example.pumpkin.controller;

import com.example.pumpkin.model.ChatModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChatController {

    public Button sendButton;
    public TextField textField;

    private ChatModel model = new ChatModel();

    //This method will run after the controller object is created
    //and the fields are initialized.

    public void initialize() {
        textField.textProperty().bindBidirectional(model.userTextProperty());
    }

    public ChatModel getModel() {
        return model;
    }

    public void sendAction(ActionEvent actionEvent) {
        model.sendMessage();
    }
}
