package sample.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Code.Manager;
import sample.Code.misc;

import java.io.IOException;
import java.sql.SQLException;

public class Controller_AddProduct {
    private static Stage primaryStage = new Stage();
    @FXML
    TextField txt_id, txt_name, txt_material, txt_category, txt_price;
    @FXML
    public void initialize(){
        txt_id.setDisable(true);
    }

    @FXML
    public void showForm() throws IOException {
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_AddProduct.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.showAndWait();
    }


    public void addNewProduct() throws SQLException, ClassNotFoundException {
        String name = null, material = null, category = null;
        Double price = null;
        String strprice = null;
        Manager manager =new Manager();

        try{
            name = txt_name.getText().trim();
            material = txt_material.getText().trim();
            category = txt_category.getText().trim();
            strprice = txt_price.getText().trim();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Enter a valid data");
        }





        System.out.println("Checkpoint");

        if (name != null && material != null && category != null && strprice != null) {
            if(!(name.isEmpty()) && !(material.isEmpty()) && !(category.isEmpty()) && !(strprice.isEmpty())  ){
                if(misc.isDouble(strprice)) {
                    manager.addNewProduct(txt_name.getText().trim(), txt_material.getText().trim(), txt_category.getText().trim(), Double.parseDouble(txt_price.getText().trim()));
                    primaryStage.close();
                }else{
                    misc.msgBox("Add Product","Error", "Data Entered is not valid");
                }
            }else {
                misc.msgBox("Add Product","Error", "Text field cannot be empty");
            }
        }

    }

    public void Cancel() {
        primaryStage.close();
    }
}
