package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Controller_Login {
    @FXML
    TextField text_username;
    @FXML
    PasswordField text_password;

    public static Stage primaryStage = new Stage();

    public static void showStage() throws IOException {
        Parent root = FXMLLoader.load(Controller_Login.class.getResource("UI_Login.fxml"));

        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();

    }



    public void pressButton(ActionEvent event){
        System.out.println("Pressed!");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from user WHERE user.user_username = '" + text_username.getText() + "'");
            String username = "";
            String password = "";
            int role = 0;
            String name = "";
            while (rs.next()) {
                username = rs.getString(2);
                password = rs.getString(3);
                role = rs.getInt(4);
                name = rs.getString(5);
            }
            if (text_username.getText().equals(username) && text_password.getText().equals(password)){
                System.out.println("Logged In!");
                try {
                    Main.login.setLoggedin_username(username);
                    Main.login.setLoggedin_role(role);
                    Main.login.setLoggedin_name(name);
                    Controller_Menu.showStage();
                    primaryStage.hide();

                }catch (Exception e){
                    System.out.println(e);
                }


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
