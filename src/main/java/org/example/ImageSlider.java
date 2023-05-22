package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class ImageSlider{
    private int j = 0;
    private int numOfImages = 15;
    private Image[] images;
    @FXML
    Button lbutton;
    @FXML
    Button rButton;
    @FXML
    ImageView imageView;
    @FXML
    private Pane MenubarPane;

    @FXML
    private ComboBox<String> ImageList;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
        Parent menuBarParent = App.loadFXML("Menubar");
        MenubarPane.getChildren().clear();
        MenubarPane.getChildren().add(menuBarParent);
        try {
            images = new Image[numOfImages];
            String filename = "images";
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resourceUrl = classLoader.getResource(filename);
            String filePath = resourceUrl.getPath();
            for (int i = 0; i < numOfImages; i++) {
                File file = new File(filePath +i+".jpg");
                images[i] =  new Image(file.toURI().toString());
                ImageList.getItems().add(String.valueOf(i));
            }
            imageView.setImage(images[j]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goLeft(ActionEvent event) {
        if(j>0){
            j--;
        }else{
            j=numOfImages-1;
        }
        imageView.setImage(images[j]);
    }

    @FXML
    void goRight(ActionEvent event) {
        if(j<numOfImages-1){
            j++;
        }else{
            j=0;
        }
        imageView.setImage(images[j]);
    }

    @FXML
    void switchImage(ActionEvent event) {
        j = Integer.parseInt(ImageList.getSelectionModel().getSelectedItem());
        imageView.setImage(images[j]);
    }
}