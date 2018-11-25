package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Code.Staff;
import sample.Main;
import java.io.IOException;

public class Controller_Menu {

    @FXML
    Label labelwelcome;
    @FXML
    Button buttonUserAccount, buttonHome, buttonTender, buttonProduct, buttonReport;

    @FXML
    private void initialize() {
        labelwelcome.setText("Welcome, "+Main.login.getLoggedin_name());
        buttonUserAccount.setDisable(true);
        buttonHome.setDisable(true);
        buttonTender.setDisable(true);
        buttonProduct.setDisable(true);
        buttonReport.setDisable(true);

        if (Main.login.getLoggedin_role() == 1){buttonUserAccount.setDisable(false);}
        else if (Main.login.getLoggedin_role() == 2){
            buttonProduct.setDisable(false);
            buttonTender.setDisable(false);
            buttonReport.setDisable(false);
        }
        else if (Main.login.getLoggedin_role() == 3){buttonTender.setDisable(false);}
    }


    Stage getPrimaryStage(){
        return (Stage) (buttonHome.getScene().getWindow());
    }

    void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Menu.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void gotoLogin() throws IOException {
        Staff.signout();
        getPrimaryStage().close();

    }

    public void gotoUserAccount() throws IOException {
        Controller_UserAccount ControllerAccount = new Controller_UserAccount();
        ControllerAccount.showForm();
        getPrimaryStage().close();

    }


    public void gotoHome() {
        getPrimaryStage().show();

    }


    public void gotoProduct() throws IOException {
        Controller_Product productmenu = new Controller_Product();
        productmenu.showForm();
        getPrimaryStage().close();

    }

    public void gotoReport() throws IOException {
        Controller_Report reportmenu = new Controller_Report();
        reportmenu.showForm();
        getPrimaryStage().close();
    }

    public void gotoTenderList() throws IOException {
        Controller_Tender requestmenu = new Controller_Tender();
        requestmenu.showForm();
        getPrimaryStage().close();
    }
}
