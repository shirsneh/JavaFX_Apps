package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage appStage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        appStage = stage;
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setWindowTitle(String title) {
        appStage.setTitle(title);
    }

    public static void setContent(String pageName) throws IOException {
        Parent root= loadFXML(pageName);
        scene = new Scene(root);
        appStage.setScene(scene);
        appStage.show();
    }

    public static void switchScreen (String screenName){
        switch (screenName){
            case "Clock":
                Platform.runLater(() -> {
                    setWindowTitle("My Clock");
                    try {
                        setContent("Clock");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case "Image Gallery":
                Platform.runLater(() -> {
                    setWindowTitle("My image gallery");
                    try {
                        setContent("ImageSlider");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case "Calculator":
                Platform.runLater(() -> {
                    setWindowTitle("My calculator");
                    try {
                        setContent("Calculator");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case "Contacts":
                Platform.runLater(() -> {
                    setWindowTitle("My Contacts");
                    try {
                        setContent("Contacts");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case "Main":
                Platform.runLater(() -> {
                    setWindowTitle("Main Screen");
                    try {
                        setContent("primary");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}