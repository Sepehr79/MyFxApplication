package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.model.modelControllers.FileHelper;
import sample.model.modelControllers.List;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPageController implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Label warningLabel;

    @FXML
    private Button button;

    @FXML
    private void buttonClicked(MouseEvent actionEvent) throws IOException, ClassNotFoundException {
        List myList = FileHelper.readList();
        if (name.getText().equals("") || password.getText().equals("")){
            warningLabel.setText("please fill out all requests");
            warningLabel.setStyle("-fx-text-fill: #ffcc00;");
        } else if (!name.getText().equals(myList.getMaster().getUserName()) || !password.getText().equals(myList.getMaster().getPassword())){
            warningLabel.setText("wrong username or password");
            warningLabel.setStyle("-fx-text-fill: #ff3300;");
        } else {
            createNewPage();
            Stage stage = (Stage) warningLabel.getScene().getWindow();
            stage.close();
        }
        warningLabel.setVisible(true);
    }
    private void createNewPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/MasterPage.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Master Page");
        newStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button.setTooltip(new Tooltip("For the first use enter admin as user and 1234 as password."));
    }
}
