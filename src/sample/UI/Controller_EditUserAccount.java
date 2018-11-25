package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Code.Manager;
import sample.Code.Staff;
import sample.Code.SystemAdmin;
import sample.Code.misc;

import java.io.IOException;
import java.sql.*;

public class Controller_EditUserAccount {

    @FXML
    TextField txt_id, txt_username, txt_password, txt_role, txt_name, txt_contact, txt_address;

    public void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_EditUserAccount.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    void search() throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_id.getText().trim();
        Staff staff = null;

        if (misc.isInteger(strid)) {
            id = Integer.parseInt(strid);
            System.out.println("id is number");
            staff = SystemAdmin.searchStaff(id);
        } else {
            System.out.println("id not number");
            misc.msgBox("Edit Product", "Error", "ID is not valid");
        }

        try {
            txt_username.setText(staff.getUsername());
            txt_password.setText(staff.getPassword());
            txt_role.setText(String.valueOf(staff.getUserRole()));
            txt_name.setText(staff.getName());
            txt_contact.setText(staff.getUserContact());
            txt_address.setText(staff.getUserAddress());
        } catch (Exception e) {misc.msgBox("Update Staff", "Error", "ID is not valid");}


        if(txt_name.getText() == null){
            txt_username.setText("INVALID ID");
            txt_password.setText("INVALID ID");
            txt_role.setText("INVALID ID");
            txt_name.setText("INVALID ID");
            txt_contact.setText("INVALID ID");
            txt_address.setText("INVALID ID");
        }

    }

    @FXML
    void updateUser() throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_id.getText().trim();
        String username = txt_username.getText().trim();
        String password = txt_password.getText().trim();
        Integer role = null;
        String strrole = txt_role.getText().trim();
        String name = txt_name.getText().trim();
        String contact = txt_contact.getText().trim();
        String address = txt_address.getText().trim();

        if(misc.isInteger(strid)){
            id = Integer.parseInt(strid);
            System.out.println("id is number");
        }else{System.out.println("id not number");}
        if(misc.isInteger(strrole)){
            role = Integer.parseInt(strrole);
            System.out.println("price is number");
        }else{System.out.println("price not number");}

        if(!(strid.isEmpty())){
            if(!(username.isEmpty())){
                if(!(password.isEmpty())){
                    if(!(strrole.isEmpty())&& misc.isInteger(strrole)){
                        if(!(name.isEmpty())){
                            if(!(contact.isEmpty())){
                                if(!(address.isEmpty())){
                                    SystemAdmin.updateStaff(id, username, password, role, name,contact, address);
                                    getPrimaryStage().close();
                                }else{misc.msgBox("Update Product","Error", "Name is not valid");}
                            }else{misc.msgBox("Update Product","Error", "Contact is not valid");}
                        }else{misc.msgBox("Update Product","Error", "Name is not valid");}
                    }else{misc.msgBox("Update Product","Error", "Role is not valid");}
                }else{misc.msgBox("Update Product","Error", "Password is not valid");}
            }else{misc.msgBox("Update Product","Error", "Username is not valid");}
        }else{misc.msgBox("Update Product","Error", "ID is not valid");}
    }
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
//            Statement stmt = con.createStatement();
//
//            String sql = "UPDATE tendersupportsystem.user SET user_username='"+ username +"', user_password='" + password + "', user_role_id='" + role + "', user_name='" + name + "', user_contact_number='" + contact +"', user_address='" + address +"' where user_index='" + id +"'";
//            int updateCount = stmt.executeUpdate(sql);
//            getPrimaryStage().close();
//            System.out.println("Update Status: " + updateCount);
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

    @FXML
    void delete() {
        Integer id = null;
        String strid = txt_id.getText().trim();

        try {
            if(misc.isInteger(strid)){
                id = Integer.parseInt(strid);
                System.out.println("id is number");
            }
            else{System.out.println("id is not number");}
            SystemAdmin.deleteStaff(id);
            getPrimaryStage().close();
        }catch (Exception e) {e.printStackTrace();}
    }

    Stage getPrimaryStage(){
        return (Stage) (txt_id.getScene().getWindow());
    }

    @FXML
    void cancel(){
        getPrimaryStage().close();
    }

}



