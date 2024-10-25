package com.example.pumpkin.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private StringProperty userText = new SimpleStringProperty();
    private ObservableList<String> messages = FXCollections.observableArrayList();

    public ObservableList<String> getMessages() {
        return messages;
    }

    public void setMessages(ObservableList<String> messages) {
        this.messages = messages;
    }

    public String getUserText() {
        return userText.get();
    }

    public StringProperty userTextProperty() {
        return userText;
    }

    public void setUserText(String userText) {
        if (!userText.isEmpty())
            this.userText.set(userText);
    }

    public void sendMessage() {
        messages.add(userText.get());
        userText.set("");
    }
}
