package sample.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Code.Staff;

import java.io.IOException;
import java.sql.*;

public class Controller_EditUserAccount {



    @FXML
    TextField txt_id, txt_username, txt_password, txt_role, txt_name, txt_contact, txt_address;
    @FXML
    public void initialize() {

    }

    private static Stage primaryStage = new Stage();

    public void showForm() throws IOException {

        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_EditUserAccount.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }



    public void search() {
        String strid = null;
        strid = txt_id.getText().trim();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.user WHERE user_index = '" + strid + "'");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                txt_username.setText(rs.getString(2));
                txt_password.setText(rs.getString(3));
                txt_role.setText(rs.getString(4));
                txt_name.setText(rs.getString(5));
                txt_contact.setText(rs.getString(6));
                txt_address.setText(rs.getString(7));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }




        public void editUser(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            Statement stmt = con.createStatement();
            String username = txt_username.getText().trim();
            String password = txt_password.getText().trim();
            String role = txt_role.getText().trim();
            String name = txt_name.getText().trim();
            String contact = txt_contact.getText().trim();
            String address = txt_address.getText().trim();
            String id = txt_id.getText().trim();
            String sql = "UPDATE tendersupportsystem.user SET user_username='"+ username +"', user_password='" + password + "', user_role_id='" + role + "', user_name='" + name + "', user_contact_number='" + contact +"', user_address='" + address +"' where user_index='" + id +"'";
            int updateCount = stmt.executeUpdate(sql);
            System.out.println("Update Status: " + updateCount);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        }

    public void deleteUser() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            Statement stmt = con.createStatement();
            String id = txt_id.getText().trim();
            String sql = "Delete FROM tendersupportsystem.user where user_index='"+ id+"'";
            int updateCount = stmt.executeUpdate(sql);
            System.out.println("Update Status: " + updateCount);

        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
    }
}



