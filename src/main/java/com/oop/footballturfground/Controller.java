package com.oop.footballturfground;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller
{
    @javafx.fxml.FXML
    private TableColumn timeslotColumn;
    @javafx.fxml.FXML
    private TextField phonenumberTextField;
    @javafx.fxml.FXML
    private TableColumn phonenumbernameColumn;
    @javafx.fxml.FXML
    private TextField teamnameTextField;
    @javafx.fxml.FXML
    private TableColumn teamnameColumn;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private ComboBox<String> timeslotComboBox;
    @javafx.fxml.FXML
    private TextField searchtimeslotTextField;

    @javafx.fxml.FXML
    public void initialize() {
        teamnameColumn.setCellValueFactory(new PropertyValueFactory<Teamname,String>("teamname"));
        phonenumbernameColumn.setCellValueFactory(new PropertyValueFactory<Teamname,String>("phonenumber"));
        timeslotColumn.setCellValueFactory(new PropertyValueFactory<Teamname,String>("time"));

timeslotComboBox.getItems().addAll("9am","10am","11am","12pm","2pm","3pm","4pm","5pm","6pm","7pm");

    }
    ArrayList<Teamname>teamnameArrayList=new ArrayList<>();


    @javafx.fxml.FXML
    public void saveOnAction(ActionEvent actionEvent) {
        String teamname = teamnameTextField.getText();
        String phonenumber = phonenumberTextField.getText();
        String time = timeslotComboBox.getValue();

        // Check for duplicate time and phone number
        boolean duplicateTime = false;
        boolean duplicatePhoneNumber = false;

        for (Teamname team : teamnameArrayList) {
            if (team.getTime().equals(time)) {
                duplicateTime = true;
            }
            if (team.getPhonenumber().equals(phonenumber)) {
                duplicatePhoneNumber = true;
            }
        }

        if (!duplicateTime && !duplicatePhoneNumber) {
            Teamname teamnamenew = new Teamname(teamname, phonenumber, time);
            teamnameArrayList.add(teamnamenew);

            // Update the TableView with all items
            tableview.getItems().clear();
            tableview.getItems().addAll(teamnameArrayList);
        } else {
            // Handle duplicate time or phone number scenario
            if (duplicateTime && duplicatePhoneNumber) {
                showAlert(Alert.AlertType.ERROR, "Duplicate Entry", "Duplicate time slot and phone number. Please select a different time and enter a different phone number.");
            } else if (duplicateTime) {
                showAlert(Alert.AlertType.ERROR, "Duplicate Entry", "Duplicate time slot. Please select a different time.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Duplicate Entry", "Duplicate phone number. Please enter a different phone number.");
            }
        }
    }

    @javafx.fxml.FXML
    public void showteamnameOnAction(ActionEvent actionEvent) {
        String searchTime = searchtimeslotTextField.getText();
        tableview.getItems().clear();

        if (!searchTime.isEmpty()) {
            for (Teamname team : teamnameArrayList) {
                if (team.getTime().equals(searchTime)) {
                    tableview.getItems().add(team);
                }
            }
        } else {
            tableview.getItems().addAll(teamnameArrayList);
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}