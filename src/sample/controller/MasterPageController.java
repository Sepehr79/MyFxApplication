package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.controller.classControllers.Master.MainTab.MainTabController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MasterPageController implements Initializable {

    //Main Page**************************************************
    @FXML
    private Button button;

    @FXML
    private CheckBox checkBox;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    //Computer's page*******************************************
    @FXML
    private TableView table;

    @FXML
    private TableColumn userNameColl;

    @FXML
    private TableColumn operatingColl;

    @FXML
    private TableColumn processor;

    @FXML
    private TableColumn price;

    @FXML
    private Label ComputerLabel;

    @FXML
    private Button editComputerButton;

    @FXML
    private Button deleteComputerBitton;

    @FXML
    private Button addComputerButton;

    private MainTabController controller;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new MainTabController(button, checkBox, name, password);
    }

    public void changePasswordEditable(ActionEvent actionEvent) {
        controller.changePasswordEditable(actionEvent);
    }

    public void updateMaster(ActionEvent actionEvent) throws IOException {
        controller.updateMaster(actionEvent);
    }
}
