package org.example;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;



public class Clock {
    @FXML
    private TextField times;
    @FXML
    private Pane MenubarPane;

    @FXML
    void initialize() throws IOException {
        Parent menuBarParent = App.loadFXML("Menubar");
        MenubarPane.getChildren().clear();
        MenubarPane.getChildren().add(menuBarParent);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            times.setText(currentTime.format(dtf));
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

}
