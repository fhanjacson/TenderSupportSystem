package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Code.Manager;
import sample.Code.Product;
import sample.Code.misc;

import java.io.IOException;
import java.sql.*;

public class Controller_EditProduct {
    @FXML
    TextField txt_id, txt_name, txt_material, txt_category, txt_price, txt_discount, txt_markup, txt_labourcost;

    public void showForm() throws IOException {
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_EditProduct.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    void updateProduct() throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_id.getText().trim();
        String name = txt_name.getText().trim();
        String material = txt_material.getText().trim();
        String category = txt_category.getText().trim();
        Double price = null;
        String strprice = txt_price.getText().trim();
        Double discount = null;
        String strdiscount = txt_discount.getText().trim();
        Double markup = null;
        String strmarkup = txt_markup.getText().trim();
        Double labourcost = null;
        String strlabourcost = txt_labourcost.getText().trim();

        if(misc.isInteger(strid)){
            id = Integer.parseInt(strid);
            System.out.println("id is number");
        }else{System.out.println("id not number");}

        if(misc.isDouble(strprice)){
            price = Double.parseDouble(strprice);
            System.out.println("price is number");
        }else{System.out.println("price not number");}

        if(misc.isDouble(strdiscount)){
            discount = Double.parseDouble(strdiscount);
            System.out.println("discount is number");
        }else{System.out.println("discount not number");}

        if(misc.isDouble(strmarkup)){
            markup = Double.parseDouble(strmarkup);
            System.out.println("markup is number");
        }else{System.out.println("markup not number");}

        if(misc.isDouble(strlabourcost)){
            labourcost = Double.parseDouble(strlabourcost);
            System.out.println("labourcost is number");
        }else{System.out.println("labourcost not number");}

        if(!(strid.isEmpty())){
            if(!(name.isEmpty())){
                if(!(material.isEmpty())){
                    if(!(category.isEmpty())){
                        if(!(strprice.isEmpty())){
                            if(!(strdiscount.isEmpty())){
                                if(!(strmarkup.isEmpty())){
                                    if(!(strlabourcost.isEmpty())){
                                        Manager.updateProduct(id, name, material, category, price, discount, markup, labourcost);
                                        getPrimaryStage().close();
                                    }else{misc.msgBox("Update Product","Error", "Labour Cost is empty");}
                                }else{misc.msgBox("Update Product","Error", "MarkUp is empty");}
                            }else{misc.msgBox("Update Product","Error", "Discount is empty");}
                        }else{misc.msgBox("Update Product","Error", "Price is empty");}
                    }else{misc.msgBox("Update Product","Error", "Category is empty");}
                }else{misc.msgBox("Update Product","Error", "Material is empty");}
            }else{misc.msgBox("Update Product","Error", "Name is empty");}
        }else{misc.msgBox("Update Product","Error", "ID is empty");}
    }

    @FXML
    void search() throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_id.getText().trim();
        Product product = null;
        if (misc.isInteger(strid)) {
            id = Integer.parseInt(strid);
            System.out.println("id is number");
            product = Manager.searchProduct(id);
        } else {
            System.out.println("id not number");
            misc.msgBox("Edit Product", "Error", "ID is not valid");
        }

        try {
            txt_name.setText(product.getProduct_name());
            txt_material.setText(product.getProduct_material());
            txt_category.setText(product.getProduct_category());
            txt_price.setText(String.valueOf(product.getProduct_price()));
            txt_discount.setText(String.valueOf(product.getProduct_discount()));
            txt_markup.setText(String.valueOf(product.getProduct_markup()));
            txt_labourcost.setText(String.valueOf(product.getProduct_labourcost()));
        } catch (Exception e) {
            misc.msgBox("Update Tender", "Error", "ID is not valid");
        }

        if (txt_name.getText() == null) {
            txt_name.setText("INVALID ID");
            txt_material.setText("INVALID ID");
            txt_category.setText("INVALID ID");
            txt_price.setText("INVALID ID");
            txt_discount.setText("INVALID ID");
            txt_markup.setText("INVALID ID");
            txt_labourcost.setText("INVALID ID");
        }
    }
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
//            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.product WHERE Product_ID = '" + strid + "'");
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//                txt_name.setText(rs.getString(2));
//                txt_material.setText(rs.getString(3));
//                txt_category.setText(rs.getString(4));
//                txt_price.setText(rs.getString(5));
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();

    @FXML
    void delete() {

        Integer id = null;
        String strid = txt_id.getText().trim();

        try {
            if(misc.isInteger(strid)){
                id = Integer.parseInt(strid);
                System.out.println("id is number");
            }
            else{
                System.out.println("id is not number");
            }
            Manager.deleteProduct(id);
            getPrimaryStage().close();
        }catch (Exception e) {e.printStackTrace();}
    }

    Stage getPrimaryStage(){
        return (Stage) (txt_id.getScene().getWindow());
    }

    @FXML
    void cancel(){
        getPrimaryStage().close();
    }
}
