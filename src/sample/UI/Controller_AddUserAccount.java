package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Code.SystemAdmin;
import sample.Code.misc;

import java.io.IOException;
import java.sql.SQLException;

public class Controller_AddUserAccount {

    @FXML
    TextField txt_username, txt_password, txt_role, txt_name, txt_contact, txt_address;

    public void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_AddUserAccount.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    void addNewUser() throws SQLException, ClassNotFoundException {
        String username = txt_username.getText().trim();
        String password = txt_password.getText().trim();
        Integer role = null;
        String strrole = txt_role.getText().trim();
        String name = txt_name.getText().trim();
        String contact = txt_contact.getText().trim();
        String address = txt_address.getText().trim();

        if(misc.isInteger(strrole)){
            role = Integer.parseInt(strrole);
            System.out.println("price is number");
        }else{System.out.println("price not number");}

        if(!(username.isEmpty())){
            if(!(password.isEmpty())){
                if(!(strrole.isEmpty())&& misc.isInteger(strrole)){
                    if(!(name.isEmpty())){
                        if(!(contact.isEmpty())){
                            if(!(address.isEmpty())){
                                SystemAdmin.addStaff(username, password, role, name,contact, address);
                                getPrimaryStage().close();
                            }else{misc.msgBox("Update Product","Error", "Name is not valid");}
                        }else{misc.msgBox("Update Product","Error", "Contact is not valid");}
                    }else{misc.msgBox("Update Product","Error", "Name is not valid");}
                }else{misc.msgBox("Update Product","Error", "Role is not valid");}
            }else{misc.msgBox("Update Product","Error", "Password is not valid");}
        }else{misc.msgBox("Update Product","Error", "Username is not valid");}
    }

    Stage getPrimaryStage(){return (Stage) (txt_name.getScene().getWindow());}

    @FXML
    void cancel(){
        getPrimaryStage().close();
    }


}
