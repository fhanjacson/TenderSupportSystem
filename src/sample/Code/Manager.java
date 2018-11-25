package sample.Code;

import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.time.LocalDate;

public class Manager extends Staff{

    //Product
    public static ObservableList<Product> viewProduct() throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.viewProduct();
    }
    public static Product searchProduct(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.searchProduct(id);
    }
    public static void addNewProduct(String name, String material, String category, Double price, Double discount, Double markup, Double labourcosst) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.addNewProduct(name, material, category, price, discount, markup, labourcosst );
    }
    public static void updateProduct(Integer id, String name, String material, String category, Double price, Double discount, Double markup, Double labourcost) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.updateProduct(id, name, material, category, price, discount, markup, labourcost);
    }
    public static void deleteProduct(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.deleteProduct(id);
    }

    //Tender
    public static ObservableList<Tender> viewTender() throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.viewTender();
    }
    public static Tender searchTender(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.searchTender(id);
    }
    public static void addNewTender(String name, LocalDate deadline, Double total_amount, String status) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.addNewTender(name, deadline, total_amount, status);
    }
    public static void updateTender(Integer id, String name, LocalDate deadline, Double total_amount, String status) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.updateTender(id, name, deadline, total_amount, status);
    }
    public static void deleteTender(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.deleteTender(id);
    }



}
