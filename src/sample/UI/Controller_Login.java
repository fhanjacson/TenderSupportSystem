package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Code.Logging;
import sample.Code.Staff;
import sample.Code.misc;
import sample.Main;

import java.io.IOException;


public class Controller_Login {

    @FXML
    TextField text_username;
    @FXML
    PasswordField text_password;
    @FXML
    Button button_signIn;
    @FXML
    private void initialize() {
        button_signIn.setDisable(true);
    }

    private static Stage primaryStage = new Stage();
    public void gotoLogin() throws IOException {
        Parent root = FXMLLoader.load(Controller_Login.class.getResource("UI_Login.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public void buttonLogin() throws IOException {
        Staff staff = new Staff();
        staff.setUsername(text_username.getText());
        staff.setPassword(text_password.getText());
        staff.setUserRole(Main.login.getLoggedin_role());
        if (staff.signin()) {
            Controller_Menu ControllerMenu = new Controller_Menu();
            ControllerMenu.showForm();
            primaryStage.hide();
            Logging.log(Main.login.getLoggedin_username(), "Login", "");
        }
        else {
            misc.msgBox("Tender Support System", "Error", "Wrong Username or Password" );

        }

    }

    public void disableButtonWhenEmpty(){
        String username = text_username.getText();
        String password = text_password.getText();
        boolean empty = (username.isEmpty() || password.isEmpty());
        button_signIn.setDisable(empty);
    }



}
