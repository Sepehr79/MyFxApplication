package sample.controller.classControllers.Master.computership;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Computer;
import sample.model.modelControllers.FileHelper;
import sample.model.modelControllers.List;

import javafx.scene.control.*;
import java.io.IOException;

public class ComputerShipController {


    private TableView<Computer> table;


    private TableColumn<Computer, String> userNameColl;


    private TableColumn<Computer, String> operatingColl;


    private TableColumn<Computer, String> processor;


    private TableColumn<Computer, String> price;


    private Label ComputerLabel;


    private Button editComputerButton;


    private Button deleteComputerButton;


    private Button addComputerButton;

    private ObservableList<Computer> data;

    private List list;


    public ComputerShipController(TableView<Computer> table, TableColumn<Computer, String> userNameColl, TableColumn<Computer, String> operatingColl, TableColumn<Computer, String> processor,
                                  TableColumn<Computer, String> price, Label computerLabel, Button editComputerButton, Button deleteComputerButton,
                                  Button addComputerButton) {

        try {
            list = FileHelper.readList();
            data = FXCollections.observableArrayList(list.getComputers());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.table = table;

        this.userNameColl = userNameColl;
        userNameColl.setCellValueFactory(new PropertyValueFactory<Computer, String>("userName"));
        this.operatingColl = operatingColl;
        operatingColl.setCellValueFactory(new PropertyValueFactory<Computer, String>("operatingSystem"));
        this.processor = processor;
        processor.setCellValueFactory(new PropertyValueFactory<Computer, String>("processor"));
        this.price = price;
        price.setCellValueFactory(new PropertyValueFactory<Computer, String>("pricePerHour"));

        ComputerLabel = computerLabel;
        this.editComputerButton = editComputerButton;
        this.deleteComputerButton = deleteComputerButton;
        this.addComputerButton = addComputerButton;


        table.setItems(data);



    }

    public void addComputer(ActionEvent actionEvent) throws Exception {
        Computer computer = new Computer("N56J0", "Windows 10", "Core i7", 5000);
        list.add(computer);
        data.add(computer);
        FileHelper.writeList(list);
        updateTable();
    }

    public void deleteComputer(ActionEvent actionEvent) throws Exception {
        Computer computer = table.getSelectionModel().getSelectedItem();
        if (computer != null){
            list.deleteComputers(computer.getUserName());
            data.remove(computer);
            FileHelper.writeList(list);
            updateTable();
        }

    }

    public void updateTable(){
        table.setItems(data);
    }

}
