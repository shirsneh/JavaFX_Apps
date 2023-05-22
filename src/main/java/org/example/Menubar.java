package org.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class Menubar {

    @FXML
    private Menu Contacts;

    @FXML
    private Menu Calculator;

    @FXML
    private Menu Clock;

    @FXML
    private MenuItem GoTOContacts;

    @FXML
    private MenuItem GoTOCalc;

    @FXML
    private MenuItem GoToClock;

    @FXML
    private Menu ImageSlide;

    @FXML
    private MenuItem ShowImages;

    @FXML
    private Button exitBtn;

    @FXML
    private MenuItem mainPageBtn;

    @FXML
    void pressCalc(ActionEvent event) {
        App.switchScreen("Calculator");
    }

    @FXML
    void pressClock(ActionEvent event) {
        App.switchScreen("Clock");
    }

    @FXML
    void pressMainPage(ActionEvent event) {
        App.switchScreen("Main");
    }

    @FXML
    void pressContacts(ActionEvent event) {
        App.switchScreen("Contacts");
    }

    @FXML
    void pressOnExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void pressShowImages(ActionEvent event) {
        App.switchScreen("Image Gallery");
    }

    @FXML
    void initialize() {

    }

}
