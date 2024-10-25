package com.example.pumpkin.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private final StringProperty userText = new SimpleStringProperty("");
    private final ObservableList<String> messages = FXCollections.observableArrayList();

    public ObservableList<String> getMessages() {
        return messages;
    }

    public String getUserText() {
        return userText.get();
    }

    public StringProperty userTextProperty() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText.set(userText);
    }

    public void sendMessage() {
        messages.add(userText.get());
        userText.set("");
    }
}
