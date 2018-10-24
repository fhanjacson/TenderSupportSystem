package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Controller {
    @FXML
    TextField text_username;
    @FXML
    PasswordField text_password;

    public void pressButton(ActionEvent event){
        System.out.println("Pressed!");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from user");
            String username = "";
            String password = "";
            while (rs.next()) {
                username = rs.getString(2);
                password = rs.getString(3);
            }
            if (text_username.getText().equals(username) && text_password.getText().equals(password)){
                System.out.println("Logged In!");
            }
            else{
                System.out.println("Fail");
            }
            con.close();




        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
