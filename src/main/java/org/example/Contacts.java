package org.example;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Contacts{

    @FXML
    private TableColumn<DataRow, String> phone;

    @FXML
    private TableView<DataRow> contactsTable;

    @FXML
    private TableColumn<DataRow, String> email;

    @FXML
    private TableColumn<DataRow, String> first_name;

    @FXML
    private TableColumn<DataRow, String> last_name;

    @FXML
    private Pane MenubarPane;

    @FXML
    void initialize() throws IOException {
        Parent menuBarParent = App.loadFXML("Menubar");
        MenubarPane.getChildren().clear();
        MenubarPane.getChildren().add(menuBarParent);
        String filename = "100-sample-contacts-list-excel.csv";
        String[] columns = {"first_name", "last_name", "phone", "email"};
        List<DataRow> data = readCSVFile(filename, columns);

        first_name.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFirst_name()));
        last_name.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLast_name()));
        phone.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPhone()));
        email.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail()));
        contactsTable.setItems(FXCollections.observableList(data));
    }

    public static List<DataRow> readCSVFile(String filename, String[] columns) {
        List<DataRow> data = new ArrayList<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resourceUrl = classLoader.getResource(filename);
        String filePath = resourceUrl.getPath();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String delimiter = ",";

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);

                if (values.length >= columns.length) {
                    DataRow obj = new DataRow(values[0], values[1], values[2], values[3]);
                    data.add(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

}

