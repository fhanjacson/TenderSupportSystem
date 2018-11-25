package sample.Code;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public class Officer extends Staff {


    public static ObservableList<TenderProduct> viewTenderProduct() throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.viewTenderProduct();
    }

    public static void addProductToTender(Integer tenderID, Integer productID) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.addProductToTender(tenderID, productID);
    }


    public static void calculate(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.calculateTenderTotalAmount(id);
    }

    public static ObservableList<TenderProduct> viewDetailedTenderProduct() throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.viewDetailedTenderProduct();
    }
}
