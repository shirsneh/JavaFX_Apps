package org.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.example.Calculator.DecCalc;
import org.example.Calculator.HexCalc;

import java.io.IOException;

public class CalculatorController {

    @FXML
    private Pane MenubarPane;

    @FXML // fx:id="aBtn"
    private Button aBtn; // Value injected by FXMLLoader

    @FXML // fx:id="bBtn"
    private Button bBtn; // Value injected by FXMLLoader

    @FXML // fx:id="cBtn"
    private Button cBtn; // Value injected by FXMLLoader

    @FXML // fx:id="clearBtn"
    private Button clearBtn; // Value injected by FXMLLoader

    @FXML // fx:id="dBtn"
    private Button dBtn; // Value injected by FXMLLoader

    @FXML // fx:id="divBtn"
    private Button divBtn; // Value injected by FXMLLoader

    @FXML // fx:id="eBtn"
    private Button eBtn; // Value injected by FXMLLoader

    @FXML // fx:id="eightBtn"
    private Button eightBtn; // Value injected by FXMLLoader

    @FXML // fx:id="fBtn"
    private Button fBtn; // Value injected by FXMLLoader

    @FXML // fx:id="fiveBtn"
    private Button fiveBtn; // Value injected by FXMLLoader

    @FXML // fx:id="fourBtn"
    private Button fourBtn; // Value injected by FXMLLoader

    @FXML // fx:id="mainTF"
    private TextField mainTF; // Value injected by FXMLLoader

//    @FXML
//    private ComboBox<String> baseList;
//
    @FXML // fx:id="baseBtn"
    private Button baseBtn; // Value injected by FXMLLoader

    @FXML // fx:id="baseTF"
    private TextField baseTF; // Value injected by FXMLLoader
    private String chosenBase;

    @FXML // fx:id="mulBtn"
    private Button mulBtn; // Value injected by FXMLLoader

    @FXML // fx:id="nineBtn"
    private Button nineBtn; // Value injected by FXMLLoader

    @FXML // fx:id="oneBtn"
    private Button oneBtn; // Value injected by FXMLLoader

    @FXML // fx:id="plusBtn"
    private Button plusBtn; // Value injected by FXMLLoader

    @FXML // fx:id="sevenBtn"
    private Button sevenBtn; // Value injected by FXMLLoader

    @FXML // fx:id="sixBtn"
    private Button sixBtn; // Value injected by FXMLLoader

    @FXML // fx:id="solveBtn"
    private Button solveBtn; // Value injected by FXMLLoader

    @FXML // fx:id="subBtn"
    private Button subBtn; // Value injected by FXMLLoader

    @FXML // fx:id="threeBtn"
    private Button threeBtn; // Value injected by FXMLLoader

    @FXML // fx:id="twoBtn"
    private Button twoBtn; // Value injected by FXMLLoader

    @FXML // fx:id="zeroBtn"
    private Button zeroBtn; // Value injected by FXMLLoader

    @FXML
    void ClearExp(ActionEvent event) {
        mainTF.clear();
    }

    @FXML
    void calc(ActionEvent event) {
        String str = mainTF.getText();
        if(chosenBase.equals("Dec")){
            DecCalc currCalc = new DecCalc();
            mainTF.setText(currCalc.decCalc(str));
        }else if(chosenBase.equals("Hex")){
            HexCalc currCalc = new HexCalc();
            mainTF.setText(currCalc.hexCalc(str));
        }
    }

    @FXML
    void pressA(ActionEvent event) {
        mainTF.appendText("A");
    }

    @FXML
    void pressB(ActionEvent event) {
        mainTF.appendText("B");
    }

    @FXML
    void pressC(ActionEvent event) {
        mainTF.appendText("C");
    }

    @FXML
    void pressD(ActionEvent event) {
        mainTF.appendText("D");
    }

    @FXML
    void pressDiv(ActionEvent event) {
        mainTF.appendText("/");
    }

    @FXML
    void pressE(ActionEvent event) {
        mainTF.appendText("E");
    }

    @FXML
    void pressEight(ActionEvent event) {
        mainTF.appendText("8");
    }

    @FXML
    void pressF(ActionEvent event) {
        mainTF.appendText("F");
    }

    @FXML
    void pressFive(ActionEvent event) {
        mainTF.appendText("5");
    }

    @FXML
    void pressFour(ActionEvent event) {
        mainTF.appendText("4");
    }

    @FXML
    void pressMul(ActionEvent event) {
        mainTF.appendText("*");
    }

    @FXML
    void pressNine(ActionEvent event) {
        mainTF.appendText("9");
    }

    @FXML
    void pressPlus(ActionEvent event) {
        mainTF.appendText("+");
    }

    @FXML
    void pressSeven(ActionEvent event) {
        mainTF.appendText("7");
    }

    @FXML
    void pressSix(ActionEvent event) {
        mainTF.appendText("6");
    }

    @FXML
    void pressSub(ActionEvent event) {
        mainTF.appendText("-");
    }

    @FXML
    void pressThree(ActionEvent event) {
        mainTF.appendText("3");
    }

    @FXML
    void pressTwo(ActionEvent event) {
        mainTF.appendText("2");
    }

    @FXML
    void pressZero(ActionEvent event) {
        mainTF.appendText("0");
    }

    @FXML
    void presssOne(ActionEvent event) {
        mainTF.appendText("1");
    }

    @FXML
    void switchBase(ActionEvent event) {
//        chosenBase = baseList.getSelectionModel().getSelectedItem();
        chosenBase = baseTF.getText();
        mainTF.clear();
        if(chosenBase.equals("Dec")){
            aBtn.setDisable(true);
            bBtn.setDisable(true);
            cBtn.setDisable(true);
            dBtn.setDisable(true);
            eBtn.setDisable(true);
            fBtn.setDisable(true);
        }else{
            aBtn.setDisable(false);
            bBtn.setDisable(false);
            cBtn.setDisable(false);
            dBtn.setDisable(false);
            eBtn.setDisable(false);
            fBtn.setDisable(false);
        }
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
//        baseList.getItems().add("Dec");
//        baseList.getItems().add("Hex");
        chosenBase = "Hex";
        baseTF.setText("Hex");
        Parent menuBarParent = org.example.App.loadFXML("MenuBar");
        MenubarPane.getChildren().clear();
        MenubarPane.getChildren().add(menuBarParent);
    }

    public static void showAlert(String title, String head) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(head);
            alert.showAndWait();
        });
    }


}
