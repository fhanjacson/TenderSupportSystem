package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Code.Login;
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

    public void gotoLogin() throws IOException {
        Stage primaryStage = new Stage();
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
            if(Main.login.getLoggedin_role() == 1){
                Controller_UserAccount userAccount = new Controller_UserAccount();
                userAccount.showForm();
            }else if(Main.login.getLoggedin_role() == 2){
                Controller_Menu menu = new Controller_Menu();
                menu.showForm();
            }else if(Main.login.getLoggedin_role() == 3){
                Controller_TenderList tenderList = new Controller_TenderList();
                tenderList.showForm();
            }

            getPrimaryStage().close();
            Login.log(Main.login.getLoggedin_username(), "Login", "");
        }
        else {
            misc.msgBox("Tender Support System", "Error", "Wrong Username or Password" );

        }

    }
    Stage getPrimaryStage(){
        return (Stage) (button_signIn.getScene().getWindow());
    }

    public void disableButtonWhenEmpty(){
        String username = text_username.getText();
        String password = text_password.getText();
        boolean empty = (username.isEmpty() || password.isEmpty());
        button_signIn.setDisable(empty);
    }



}
