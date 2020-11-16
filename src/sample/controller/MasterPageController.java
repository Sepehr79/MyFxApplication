package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.controller.classControllers.Master.MainTab.MainTabController;
import sample.controller.classControllers.Master.computership.ComputerShipController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MasterPageController implements Initializable {

    /**
     * main page
     */
    @FXML
    private Button button;

    @FXML
    private CheckBox checkBox;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    /**
     * computer page
     */
    @FXML
    private TableView<sample.model.Computer> table;

    @FXML
    private TableColumn<sample.model.Computer, String> userNameColl;

    @FXML
    private TableColumn<sample.model.Computer, String> operatingColl;

    @FXML
    private TableColumn<sample.model.Computer, String> processor;

    @FXML
    private TableColumn<sample.model.Computer, String> price;

    @FXML
    private Label ComputerLabel;

    @FXML
    private Button editComputerButton;

    @FXML
    private Button deleteComputerButton;

    @FXML
    private Button addComputerButton;

    /**
     * tabs
     */
    private MainTabController mainTabController;
    private ComputerShipController computerShipController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainTabController = new MainTabController(button, checkBox, name, password);
        computerShipController = new ComputerShipController(table, userNameColl, operatingColl, processor, price,
                ComputerLabel, editComputerButton, deleteComputerButton, addComputerButton);
    }

    public void changePasswordEditable(ActionEvent actionEvent) {
        mainTabController.changePasswordEditable(actionEvent);
    }

    public void updateMaster(ActionEvent actionEvent) throws IOException {
        mainTabController.updateMaster(actionEvent);
    }

    public void addComputer(ActionEvent actionEvent) {
        try {
            computerShipController.addComputer(actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteComputer(ActionEvent actionEvent) {
        try {
            computerShipController.deleteComputer(actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
