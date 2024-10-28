package com.example.pumpkin.model;

import com.example.pumpkin.Pumpkin;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Random;

public class Model {

    private int score = 0;
    private StringProperty scoring = new SimpleStringProperty("0 poäng");
    Image noSmash;
    Image smash;
    Image smash1;
    Image smash2;
    Image doNotSmash;

//    ObjectProperty<Image> firstPumpkin;
//    ObjectProperty<Image> secondPumpkin;
//    ObjectProperty<Image> thirdPumpkin;

    Random random = new Random();

    private ListProperty<Image> images = new SimpleListProperty<>(FXCollections.observableArrayList());

    public Model() {
        noSmash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin_blank.png").toExternalForm());
        smash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin1.png").toExternalForm());
        smash1 = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin2.png").toExternalForm());
        smash2 = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin3.png").toExternalForm());
        doNotSmash = new Image(getClass().getResource("/com/example/pumpkin/images/pumpkin4.png").toExternalForm());
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
            selectImage(0);
        } else if (randomPumpkin == 2) {
            selectImage(1);
        } else {
            selectImage(2);
        }
    }

    private void selectImage(int i) {
        double probability = random.nextDouble();
        if (probability < 0.2)
            images.set(i, smash);
        else if (probability < 0.4)
            images.set(i, smash1);
        else if (probability < 0.6)
            images.set(i, smash2);
        else if (probability < 0.9)
            images.set(i, noSmash);
        else
            images.set(i, doNotSmash);
    }

    public void pumpkinSmashed(Pumpkin pumpkin) {
        //Check if we can smack this pumpkin
        //Increase score
        if (pumpkin == Pumpkin.FIRST && getFirstPumpkin() != noSmash) {
            if (getFirstPumpkin() == doNotSmash) score--;
            else
                score++;
            images.set(0, noSmash);
        } else if (pumpkin == Pumpkin.SECOND && getSecondPumpkin() != noSmash) {
            if (getSecondPumpkin() == doNotSmash) score--;
            else
                score++;
            images.set(1, noSmash);
        } else if (pumpkin == Pumpkin.THIRD && getThirdPumpkin() != noSmash) {
            if (getThirdPumpkin() == doNotSmash) score--;
            else
                score++;
            images.set(2, noSmash);
        }

        setScoring(score + " poäng");
    }
}
