package sample.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.Code.SystemAdmin;
import sample.Code.misc;

import java.io.IOException;

public class Controller_AddUserAccount {

    private static Stage primaryStage = new Stage();
    private SystemAdmin admin = new SystemAdmin();

    @FXML
    TextField txt_id, txt_username, txt_password, txt_role, txt_name, txt_contact, txt_address;

    @FXML
    public void initialize(){
        txt_id.setDisable(true);
    }

    @FXML
    public void showForm() throws IOException {
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_AddUserAccount.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.showAndWait();
    }

    public void addNewUser(){
        String username = null;
        String password = null;
        Integer role = 0;
        String strrole = null;
        String name = null;
        String contact = null;
        String address = null;

        strrole = txt_role.getText();
        if(misc.isInteger(strrole)){
            role = Integer.parseInt(txt_role.getText().trim());
            System.out.println("role is number");
        }
        else{
            System.out.println("role is not number");
        }

        try {
            username = txt_username.getText().trim();
            password = txt_password.getText().trim();
            name = txt_name.getText().trim();
            contact = txt_contact.getText().trim();
            address = txt_address.getText().trim();
        }catch (Exception e) {
            e.printStackTrace();
        }

        if (password != null && contact !=null && address != null) {
            if(!(username.isEmpty()) && !(password.isEmpty()) && !(role.toString().isEmpty()) && !(contact.isEmpty()) && !(address.isEmpty())){
                if(misc.isInteger(strrole)){
                    admin.addNewUser(username, password, role, name,contact, address);
                    primaryStage.close();
                }
                else{
                    misc.msgBox("Add User", "Error", "role is not an integer number");
                }
            }
            else{
                misc.msgBox("Add User", "Error", "Text Field cannot be empty");
            }
        }

    }

    public void Cancel() {
        primaryStage.close();
    }


}
