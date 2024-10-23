package com.example.pumpkin.model;

import com.example.pumpkin.Pumpkin;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Random;

public class Model {

    private int score = 0;
    private StringProperty scoring = new SimpleStringProperty("0 poäng");
    Image noSmash;
    Image smash;

//    ObjectProperty<Image> firstPumpkin;
//    ObjectProperty<Image> secondPumpkin;
//    ObjectProperty<Image> thirdPumpkin;

    Random random = new Random();

    private ListProperty<Image> images = new SimpleListProperty<>(FXCollections.observableArrayList());

    public Model() {
        noSmash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin_blank.png").toExternalForm());
        smash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin1.png").toExternalForm());
        images.add(noSmash);
        images.add(noSmash);
        images.add(noSmash);
    }

    public ObservableList<Image> getImages() {
        return images.get();
    }

    public ListProperty<Image> imagesProperty() {
        return images;
    }

    public void setImages(ObservableList<Image> images) {
        this.images.set(images);
    }

    public String getScoring() {
        return scoring.get();
    }

    public StringProperty scoringProperty() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring.set(scoring);
    }

    public Image getFirstPumpkin() {
        return images.getFirst();
    }

    public Image getSecondPumpkin() {
        return images.get(1);
    }

    public Image getThirdPumpkin() {
        return images.get(2);
    }

    public void randomlyChangeOnePumpkin() {
        int randomPumpkin = random.nextInt(4);
        if (randomPumpkin == 1) {
            images.set(0, smash);
        } else if (randomPumpkin == 2) {
            images.set(1, smash);
        } else {
            images.set(2, smash);
        }
    }

    public void pumpkinSmashed(Pumpkin pumpkin) {
        //Check if we can smack this pumpkin
        //Increase score
        if (pumpkin == Pumpkin.FIRST && getFirstPumpkin() == smash) {
            images.set(0, noSmash);
            score++;
        } else if (pumpkin == Pumpkin.SECOND && getSecondPumpkin() == smash) {
            images.set(1, noSmash);
            score++;
        } else if (pumpkin == Pumpkin.THIRD && getThirdPumpkin() == smash) {
            images.set(2, noSmash);
            score++;
        }
        setScoring(score + " poäng");
    }
}
