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
    private ObservableList<Product> productdetail = FXCollections.observableArrayList();
    @FXML Button buttonAdd, buttonEdit;
    @FXML TableView<Product> tableView;
    @FXML TableColumn<Product, Integer> Column1;
    @FXML TableColumn<Product, String> Column2;
    @FXML TableColumn<Product, String> Column3;
    @FXML TableColumn<Product, String> Column4;
    @FXML TableColumn<Product, Double> Column5;
    @FXML TableColumn<Product, Double> Column6;
    @FXML TableColumn<Product, Double> Column7;
    @FXML TableColumn<Product, Double> Column8;


    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        Column1.setCellValueFactory(new PropertyValueFactory<>("product_index"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("product_material"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("product_category"));
        Column5.setCellValueFactory(new PropertyValueFactory<>("product_price"));
        Column6.setCellValueFactory(new PropertyValueFactory<>("product_discount"));
        Column7.setCellValueFactory(new PropertyValueFactory<>("product_markup"));
        Column8.setCellValueFactory(new PropertyValueFactory<>("product_labourcost"));

        productdetail = Manager.viewProduct();
        tableView.setItems(productdetail);
    }


    void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Product.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 900, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void gotoLogin() throws IOException {
        Staff.signout();
        getPrimaryStage().close();

    }

    public void add() throws IOException {
        Controller_AddProduct addproduct = new Controller_AddProduct();
        addproduct.showForm();
    }

    public void edit() throws IOException {
        Controller_EditProduct editProduct = new Controller_EditProduct();
        editProduct.showForm();
    }


    public void refreshTable() throws SQLException, ClassNotFoundException {
        tableView.setItems(null);
        productdetail.clear();
        productdetail = Manager.viewProduct();
        tableView.setItems(productdetail);

    }

    Stage getPrimaryStage(){
        return (Stage) (buttonAdd.getScene().getWindow());
    }

}
