package com.example.pumpkin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private StringProperty userText = new SimpleStringProperty();

    public String getUserText() {
        return userText.get();
    }

    public StringProperty userTextProperty() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText.set(userText);
    }
}
