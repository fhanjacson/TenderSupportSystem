package sample.UI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Code.*;

import java.io.IOException;
import java.sql.SQLException;

public class Controller_TenderList {
    public Button buttonAdd, buttonEdit, btnRefresh, btnApply;
    public TextField txt_tenderid, txt_productid;

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
    @FXML TableView<TenderProduct> tableList;
    @FXML TableColumn<TenderProduct, Integer> list1;
    @FXML TableColumn<TenderProduct, Integer> list2;


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

        productdetail = Manager.viewProduct();
        tenderdetail = Manager.viewTender();
        tenderproductdetail = Officer.viewTenderProduct();

        tableTender.setItems(tenderdetail);
        tableProduct.setItems(productdetail);
        tableList.setItems(tenderproductdetail);
    }



    public void add() throws IOException, SQLException, ClassNotFoundException {
        Integer tenderid = null;
        String strtenderid = txt_tenderid.getText().trim();
        Integer productid = null;
        String strproductid = txt_productid.getText().trim();

        if(misc.isInteger(strtenderid)){
            tenderid = Integer.parseInt(strtenderid);
            System.out.println("Tender ID valid");
        }else{System.out.println("Tender ID invalid");}
        if(misc.isInteger(strproductid)){
            productid = Integer.parseInt(strproductid);
            System.out.println("Product ID valid");
        }else{System.out.println("Product ID invalid");}


        if(!(strtenderid.isEmpty()) && !(strproductid.isEmpty())){
            Officer.addProductToTender(tenderid, productid);
        }else{misc.msgBox("Add Product to Tender","Tender ID or Product ID invalid", "Select the Tender ID and the product ID to entered");}

    }



    public void refreshTable() throws SQLException, ClassNotFoundException {
        //Delete items in Table
        tableTender.setItems(null);
        tableProduct.setItems(null);
        tableList.setItems(null);

        //Clear Clas object
        tenderdetail.clear();
        productdetail.clear();
        tenderproductdetail.clear();

        //Get Value from Class
        tenderdetail = Manager.viewTender();
        productdetail = Manager.viewProduct();
        tenderproductdetail = Officer.viewTenderProduct();

        //Insert Value to Table
        tableTender.setItems(tenderdetail);
        tableProduct.setItems(productdetail);
        tableList.setItems(tenderproductdetail);
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
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void getTenderID(MouseEvent mouseEvent) {
        if(buttonAdd.isDisable() && buttonEdit.isDisable()){
            buttonAdd.setDisable(false);
            buttonEdit.setDisable(false);
        }
        Tender tender = tableTender.getSelectionModel().getSelectedItem();
        txt_tenderid.setText(String.valueOf(tender.getTender_id()));
    }

    public void getProductID(MouseEvent mouseEvent) {
        if(buttonAdd.isDisable() && buttonEdit.isDisable()){
            buttonAdd.setDisable(false);
            buttonEdit.setDisable(false);
        }
        Product product = tableProduct.getSelectionModel().getSelectedItem();
        txt_productid.setText(String.valueOf(product.getProduct_index()));
    }

    public void getTenderProduct(MouseEvent mouseEvent) {
        if(buttonAdd.isDisable() && buttonEdit.isDisable()){
            buttonAdd.setDisable(false);
            buttonEdit.setDisable(false);
        }
        TenderProduct tenderProduct = tableList.getSelectionModel().getSelectedItem();
        txt_tenderid.setText(String.valueOf(tenderProduct.getTender_id()));
        txt_productid.setText(String.valueOf(tenderProduct.getProduct_id()));
    }


    public void edit() throws IOException {
        txt_tenderid.setDisable(false);
        txt_productid.setDisable(false);
        btnApply.setDisable(false);
        buttonAdd.setDisable(true);
        buttonEdit.setDisable(true);
    }

    public void apply(ActionEvent actionEvent) {
        txt_tenderid.setDisable(true);
        txt_productid.setDisable(true);
        btnApply.setDisable(true);
        buttonAdd.setDisable(false);
        buttonEdit.setDisable(false);

    }

    public void calculate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_tenderid.getText().trim();
        if(misc.isInteger(strid)){
            id = Integer.parseInt(strid);
            System.out.println("id is number");
        }else{System.out.println("id not number");}

        if(!(strid.isEmpty())){
            Officer.calculate(id);
        }else{misc.msgBox("Calculate Tender Total Amount", "Error", "ID is invalid");}
    }
}
