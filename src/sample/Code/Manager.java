package sample.Code;

import java.sql.SQLException;

public class Manager {


    public void addNewProduct(String name, String material, String category, Double price) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.addNewProduct(name, material, category, price);

    }
}
