package sample.UI;

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
    @FXML
    TextField txt_name, txt_material, txt_category, txt_price, txt_discount, txt_markup, txt_labourcost;

    public void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_AddProduct.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    void addNewProduct() throws SQLException, ClassNotFoundException {
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


            if(!(name.isEmpty())){
                if(!(material.isEmpty())){
                    if(!(category.isEmpty())){
                        if(!(strprice.isEmpty()) && misc.isDouble(strprice)){
                            if(!(strdiscount.isEmpty()) && misc.isDouble(strdiscount)){
                                if(!(strmarkup.isEmpty()) && misc.isDouble(strmarkup)){
                                    if(!(strlabourcost.isEmpty()) && misc.isDouble(strlabourcost)){
                                        Manager.addNewProduct(name, material, category, price, discount, markup, labourcost);
                                        getPrimaryStage().close();
                                    }else{misc.msgBox("Update Product","Error", "Labour Cost is empty");}
                                }else{misc.msgBox("Update Product","Error", "MarkUp is empty");}
                            }else{misc.msgBox("Update Product","Error", "Discount is empty");}
                        }else{misc.msgBox("Update Product","Error", "Price is empty");}
                    }else{misc.msgBox("Update Product","Error", "Category is empty");}
                }else{misc.msgBox("Update Product","Error", "Material is empty");}
            }else{misc.msgBox("Update Product","Error", "Name is empty");}
    }

    Stage getPrimaryStage(){
        return (Stage) (txt_name.getScene().getWindow());
    }

    @FXML
    void cancel(){
        getPrimaryStage().close();
    }
}
