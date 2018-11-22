package sample.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Code.Staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller_UserAccount {

    private ObservableList<Staff> userdetail = FXCollections.observableArrayList();
    private static Stage primaryStage = new Stage();
    public Integer asd = 0;
    @FXML Button buttonAdd, buttonEdit;
    @FXML TableView<Staff> tableView;
    @FXML TableColumn<Staff, Integer> Column1;
    @FXML TableColumn<Staff, String> Column2;
    @FXML TableColumn<Staff, String> Column3;
    @FXML TableColumn<Staff, Integer> Column4;
    @FXML TableColumn<Staff, String> Column5;
    @FXML TableColumn<Staff, String> Column6;
    @FXML TableColumn<Staff, String> Column7;


    @FXML
    private void initialize() {
        Column1.setCellValueFactory(new PropertyValueFactory<>("UserIndex"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("Password"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("UserRole"));
        Column5.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Column6.setCellValueFactory(new PropertyValueFactory<>("UserContact"));
        Column7.setCellValueFactory(new PropertyValueFactory<>("UserAddress"));

        ObservableList<Staff> userdetail = FXCollections.observableArrayList();
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.user");
        while (rs.next()){
                userdetail.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));

            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}


        tableView.setItems(userdetail);

    }

    public void gotoLogin() throws IOException {
        Controller_Login login = new Controller_Login();
        login.gotoLogin();
        primaryStage.hide();
    }



    public void showForm() throws IOException {
        System.out.println("ssdsdsdsd");
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_UserAccount.fxml"));

        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    
    public void add() throws IOException {
        Controller_AddUserAccount adduser = new Controller_AddUserAccount();
        adduser.showForm();
    }


    public void edit() throws IOException {
        Controller_EditUserAccount edituser = new Controller_EditUserAccount();
        edituser.showForm();

    }


    public void refreshTable() {
        try {
            tableView.setItems(null);
            userdetail.clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.user");
            while (rs.next()){
                userdetail.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        tableView.setItems(userdetail);

    }
}
