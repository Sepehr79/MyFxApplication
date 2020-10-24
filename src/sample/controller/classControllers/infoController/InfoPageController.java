package sample.controller.classControllers.infoController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class InfoPageController {

    private InfoPageController(){}

    public static void showCheckMessage(String type, String message) throws IOException {
        Parent root = FXMLLoader.load(InfoPageController.class.getResource("../../../view/infoPages/CheckImage.fxml"));
        Scene scene = new Scene(root);

        Label typeLabel = (Label) scene.lookup("#type");
        Label messageLabel = (Label) scene.lookup("#message");
        Button button = (Button) scene.lookup("#button");

        button.setOnAction((event)->{
            Stage stage =(Stage) button.getScene().getWindow();
            stage.close();
        });

        typeLabel.setText(type);
        messageLabel.setText(message);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Warning");
        stage.show();
    }

}
