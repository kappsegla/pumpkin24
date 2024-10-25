package com.example.pumpkin.controller;

import com.example.pumpkin.model.ChatModel;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController {

    public Button sendButton;
    public TextField textField;
    public ListView listView;

    private ChatModel model = new ChatModel();

    //This method will run after the controller object is created
    //and the fields are initialized.
    public void initialize() {
        textField.textProperty().bindBidirectional(model.userTextProperty());
        model.getMessages().addListener((ListChangeListener<String>) c -> {
            listView.scrollTo(model.getMessages().size() - 1);
        });
    }

    public ChatModel getModel() {
        return model;
    }

    public void sendAction(ActionEvent actionEvent) {
        model.sendMessage();
    }
}
