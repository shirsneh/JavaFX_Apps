package org.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private Button contactsBtn;

    @FXML
    private Button calcBtn;

    @FXML
    private Button clockBtn;

    @FXML
    private Button ImageSliderBtn;

    @FXML
    void clickOnCalc(ActionEvent event) {
       App.switchScreen("Calculator");
    }

    @FXML
    void clickOnImageSlider(ActionEvent event) {
        App.switchScreen("Image Gallery");
    }

    @FXML
    void clickOnClock(ActionEvent event) {
       App.switchScreen("Clock");
    }

    @FXML
    void clickOnContacts(ActionEvent event) {
        App.switchScreen("Contacts");
    }

    @FXML
    void initialize() {


    }

}
