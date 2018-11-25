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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Code.Manager;
import sample.Code.Product;
import sample.Code.Staff;

import java.io.IOException;
import java.sql.SQLException;

public class Controller_TenderList {
    public Button buttonAdd, buttonEdit, btnRefresh;
    public TableView tableList, tableTender;
    public TableColumn list1, list2;
    public TableColumn tender1, tender2, tender3, tender4, tender5, tender6;

    //PRODUCT
    @FXML TableView<Product> tableProduct;
    @FXML TableColumn<Product, Integer> product1;
    @FXML TableColumn<Product, String> product2;
    @FXML TableColumn<Product, String> product3;
    @FXML TableColumn<Product, String> product4;
    @FXML TableColumn<Product, Double> product5;
    @FXML TableColumn<Product, Double> product6;
    @FXML TableColumn<Product, Double> product7;
    @FXML TableColumn<Product, Double> product8;

    private ObservableList<Product> productdetail = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        product1.setCellValueFactory(new PropertyValueFactory<>("product_index"));
        product2.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        product3.setCellValueFactory(new PropertyValueFactory<>("product_material"));
        product4.setCellValueFactory(new PropertyValueFactory<>("product_category"));
        product5.setCellValueFactory(new PropertyValueFactory<>("product_price"));
        product6.setCellValueFactory(new PropertyValueFactory<>("product_discount"));
        product7.setCellValueFactory(new PropertyValueFactory<>("product_markup"));
        product8.setCellValueFactory(new PropertyValueFactory<>("product_labourcost"));

        productdetail = Manager.viewProduct();
        tableProduct.setItems(productdetail);
    }



    public void add() throws IOException {
        Controller_AddTenderList addTenderList = new Controller_AddTenderList();
        addTenderList.showForm();
    }

    public void edit() throws IOException {

    }

    public void refreshTable() {
    }

    public void gotoLogin() throws IOException {
        Staff.signout();
        getPrimaryStage().close();

    }

    Stage getPrimaryStage(){
        return (Stage) (buttonAdd.getScene().getWindow());
    }

    public void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_TenderList.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void getTenderID(MouseEvent mouseEvent) {
    }

    public void getProductID(MouseEvent mouseEvent) {
    }
}
