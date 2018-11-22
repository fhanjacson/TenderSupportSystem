package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Code.Logout;
import sample.Main;
import java.io.IOException;

public class Controller_Menu {

    @FXML
    Label label1, label2, label3;
    @FXML
    Button buttonUserAccount, buttonHome, buttonRequest, buttonProduct, buttonReport;

    @FXML
    private void initialize() {
        buttonUserAccount.setDisable(true);
        buttonHome.setDisable(true);
        buttonRequest.setDisable(true);
        buttonProduct.setDisable(true);
        buttonReport.setDisable(true);

        if (Main.login.getLoggedin_role() == 1){buttonUserAccount.setDisable(false);}
        else if (Main.login.getLoggedin_role() == 2){buttonProduct.setDisable(false);}
        else if (Main.login.getLoggedin_role() == 3){buttonRequest.setDisable(false);}
    }

    private static Stage primaryStage = new Stage();

    void showForm() throws IOException {

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
        Logout.logout();
        primaryStage.hide();

    }

    public void gotoUserAccount() throws IOException {
        Controller_UserAccount ControllerAccount = new Controller_UserAccount();
        ControllerAccount.showForm();
        primaryStage.hide();

    }


    public void gotoHome() {
        primaryStage.show();
    }

    public void gotoRequest() {
        Controller_Request requestmenu = new Controller_Request();
        requestmenu.showForm();
    }

    public void gotoProduct() throws IOException {
        Controller_Product productmenu = new Controller_Product();
        productmenu.showForm();
        primaryStage.hide();

    }

    public void gotoReport() throws IOException {
        Controller_Report reportmenu = new Controller_Report();
        reportmenu.showForm();
    }
}
