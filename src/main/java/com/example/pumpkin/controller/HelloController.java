package com.example.pumpkin.controller;

import com.example.pumpkin.Pumpkin;
import com.example.pumpkin.model.Model;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HelloController {


    public ImageView image1;

    //This method will run after the controller object is created
    //and the fields are initialized.
    public void initialize() {

    }

    private Model model = new Model();


    public void image1Clicked(MouseEvent mouseEvent) {
        model.pumpkinSmashed(Pumpkin.FIRST);
    }

    public void image2Clicked(MouseEvent mouseEvent) {
        model.pumpkinSmashed(Pumpkin.SECOND);
    }

    public void image3Clicked(MouseEvent mouseEvent) {
        model.pumpkinSmashed(Pumpkin.THIRD);
    }
}
