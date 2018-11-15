package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Main;
import java.io.IOException;

public class Controller_Menu {

    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Button buttonUserAccount;
    @FXML
    private void initialize() {

        if (Main.login.getLoggedin_role() == 1 || Main.login.getLoggedin_role() == 2){
            buttonUserAccount.setDisable(false);
        }
        else {
            buttonUserAccount.setDisable(true);
        }
    }

    private static Stage primaryStage = new Stage();

    public void showForm() throws IOException {

        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Menu.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void someFunction() {
        label1.setText("Username:" + Main.login.getLoggedin_username());
        label2.setText("Role:" + Main.login.getLoggedin_role());
        label3.setText("Name:" + Main.login.getLoggedin_name());
    }

    public void gotoLogin() throws IOException {
        Controller_Login ControllerLogin = new Controller_Login();
        ControllerLogin.gotoLogin();
        primaryStage.hide();

    }

    public void gotoUserAccount() throws IOException {
        Controller_UserAccount ControllerAccount = new Controller_UserAccount();
        ControllerAccount.showForm();
        primaryStage.hide();

    }


}
