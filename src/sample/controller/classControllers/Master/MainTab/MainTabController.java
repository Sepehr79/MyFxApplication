package sample.controller.classControllers.Master.MainTab;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.controller.classControllers.infoController.InfoPageController;
import sample.model.modelControllers.FileHelper;
import sample.model.modelControllers.List;

import java.io.IOException;

public class MainTabController{

    public MainTabController(Button button, CheckBox checkBox, TextField name, TextField password) {
        this.button = button;
        this.checkBox = checkBox;
        this.name = name;
        this.password = password;

        try {
            list = FileHelper.readList();
            name.setText(list.getMaster().getUserName());
            password.setText("****");
            password.setDisable(true);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final Button button;

    private final CheckBox checkBox;

    private final TextField name;

    private final TextField password;

    private List list;



    public void changePasswordEditable(ActionEvent actionEvent) {
        if (checkBox.isSelected()){
            password.setText(list.getMaster().getPassword());
            password.setDisable(false);
        }else {
            password.setText("****");
            password.setDisable(true);
        }
    }

    public void updateMaster(ActionEvent actionEvent) throws IOException {
        if (!name.getText().equals("") && !name.getText().equals("")){

            String newUserName = name.getText();
            String newPassword = (checkBox.isSelected())? password.getText():list.getMaster().getPassword();

            list.getMaster().setUserName(newUserName);
            list.getMaster().setPassword(newPassword);

            FileHelper.writeList(list);
            InfoPageController.showCheckMessage("", "Master successfully updated\n" +
                    "username :" + newUserName + "\n" +
                    "password :" + newPassword);
        }
    }

    public Button getButton() {
        return button;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public TextField getName() {
        return name;
    }

    public TextField getPassword() {
        return password;
    }
}
