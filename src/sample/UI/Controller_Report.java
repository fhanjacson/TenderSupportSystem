package sample.UI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Code.*;

import java.io.IOException;
import java.sql.SQLException;

public class Controller_Report {


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

    //TENDER
    @FXML TableView<Tender> tableTender;
    @FXML TableColumn<Tender, Integer> tender1;
    @FXML TableColumn<Tender, String> tender2;
    @FXML TableColumn<Tender, String> tender3;
    @FXML TableColumn<Tender, String> tender4;
    @FXML TableColumn<Tender, Double> tender5;
    @FXML TableColumn<Tender, String> tender6;

    //TENDER PRODUCT
    @FXML
    TableView<TenderProduct> tableList;
    @FXML TableColumn<TenderProduct, Integer> list1;
    @FXML TableColumn<TenderProduct, Integer> list2;
    @FXML TableColumn<TenderProduct, String> list3;
    @FXML TableColumn<TenderProduct, String> list4;
    @FXML TableColumn<TenderProduct, String> list5;
    @FXML TableColumn<TenderProduct, Double> list6;
    @FXML TableColumn<TenderProduct, Double> list7;
    @FXML TableColumn<TenderProduct, Double> list8;
    @FXML TableColumn<TenderProduct, Double> list9;
    @FXML TableColumn<TenderProduct, Double> list10;

    private ObservableList<Product> productdetail;
    private ObservableList<Tender> tenderdetail;
    private ObservableList<TenderProduct> tenderproductdetail;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        //PRODUCT
        product1.setCellValueFactory(new PropertyValueFactory<>("product_index"));
        product2.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        product3.setCellValueFactory(new PropertyValueFactory<>("product_material"));
        product4.setCellValueFactory(new PropertyValueFactory<>("product_category"));
        product5.setCellValueFactory(new PropertyValueFactory<>("product_price"));
        product6.setCellValueFactory(new PropertyValueFactory<>("product_discount"));
        product7.setCellValueFactory(new PropertyValueFactory<>("product_markup"));
        product8.setCellValueFactory(new PropertyValueFactory<>("product_labourcost"));

        //TENDER
        tender1.setCellValueFactory(new PropertyValueFactory<>("Tender_id"));
        tender2.setCellValueFactory(new PropertyValueFactory<>("Tender_name"));
        tender3.setCellValueFactory(new PropertyValueFactory<>("Tender_date_created"));
        tender4.setCellValueFactory(new PropertyValueFactory<>("Tender_deadline"));
        tender5.setCellValueFactory(new PropertyValueFactory<>("Tender_total_amount"));
        tender6.setCellValueFactory(new PropertyValueFactory<>("Tender_status"));

        //TENDER PRODUCT
        list1.setCellValueFactory(new PropertyValueFactory<>("Tender_id"));
        list2.setCellValueFactory(new PropertyValueFactory<>("Product_id"));
        list3.setCellValueFactory(new PropertyValueFactory<>("Product_name"));
        list4.setCellValueFactory(new PropertyValueFactory<>("Product_material"));
        list5.setCellValueFactory(new PropertyValueFactory<>("Product_category"));
        list6.setCellValueFactory(new PropertyValueFactory<>("Product_price"));
        list7.setCellValueFactory(new PropertyValueFactory<>("Product_discount"));
        list8.setCellValueFactory(new PropertyValueFactory<>("Product_markup"));
        list9.setCellValueFactory(new PropertyValueFactory<>("Product_labourcost"));
        list10.setCellValueFactory(new PropertyValueFactory<>("Total_amount"));

        productdetail = Manager.viewProduct();
        tenderdetail = Manager.viewTender();
        tenderproductdetail = Officer.viewDetailedTenderProduct();

        tableTender.setItems(tenderdetail);
        tableProduct.setItems(productdetail);
        tableList.setItems(tenderproductdetail);


    }

        void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Report.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    Stage getPrimaryStage(){
        return (Stage) (tableList.getScene().getWindow());
    }

    public void gotoHome(ActionEvent actionEvent) throws IOException {
        Controller_Menu menugui = new Controller_Menu();
        menugui.showForm();
        getPrimaryStage().close();

    }

    public void export(ActionEvent actionEvent) {
    }
}
