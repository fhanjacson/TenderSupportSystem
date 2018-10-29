package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller_Menu {
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;

    public void someFunction(ActionEvent event){
        label1.setText("Username:" + Main.login.getLoggedin_username());
        label2.setText("Role:" + Main.login.getLoggedin_role());
        label3.setText("Name:" + Main.login.getLoggedin_name());
    }

    static void showStage() throws IOException {
        Parent root = FXMLLoader.load(Controller_Login.class.getResource("UI_Menu.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
