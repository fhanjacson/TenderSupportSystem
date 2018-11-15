package sample.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_UserAccount {

    private static Stage primaryStage = new Stage();

    public void gotoLogin() throws IOException {
        Controller_Login login = new Controller_Login();
        login.gotoLogin();
    }



    public void showForm() throws IOException {

        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_UserAccount.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
