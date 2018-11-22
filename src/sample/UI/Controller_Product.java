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
import sample.Code.Manager;
import sample.Code.Product;
import sample.Code.Staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller_Product {
    private static Stage primaryStage = new Stage();

    private ObservableList<Product> productdetail = FXCollections.observableArrayList();
    @FXML Button buttonAdd, buttonEdit;
    @FXML TableView<Product> tableView;
    @FXML TableColumn<Product, Integer> Column1;
    @FXML TableColumn<Product, String> Column2;
    @FXML TableColumn<Product, String> Column3;
    @FXML TableColumn<Product, String> Column4;
    @FXML TableColumn<Product, Double> Column5;

    @FXML
    private void initialize() {
        Column1.setCellValueFactory(new PropertyValueFactory<>("product_index"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("product_material"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("product_category"));
        Column5.setCellValueFactory(new PropertyValueFactory<>("product_price"));

        productdetail = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.product");
            while (rs.next()){
                productdetail.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}

        tableView.setItems(productdetail);
    }


    void showForm() throws IOException {
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Product.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void gotoHome(ActionEvent actionEvent) {
    }

    public void gotoLogin(ActionEvent actionEvent) {
    }

    public void add() throws IOException {
        Controller_AddProduct addproduct = new Controller_AddProduct();
        addproduct.showForm();
    }

    public void edit(ActionEvent actionEvent) {
    }


    public void refreshTable() {
        try {
            tableView.setItems(null);
            productdetail.clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.product");
            while (rs.next()){
                productdetail.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        tableView.setItems(productdetail);

    }
}
