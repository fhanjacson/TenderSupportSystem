package sample.Code;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SystemAdmin extends Staff {

    public SystemAdmin(){}

    public static ObservableList<Staff> viewStaff() throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.viewStaff();
    }
    public static Staff searchStaff(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        return dbc.searchStaff(id);
    }
    public static void addStaff(String username, String password, Integer role, String name, String contact, String address) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.addStaff(username, password, role, name,contact, address);
    }

    public static void updateStaff(Integer id, String username, String password, Integer role, String name, String contact, String address) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.updateStaff(id, username, password, role, name, contact, address );
    }

    public static void deleteStaff(Integer id) throws SQLException, ClassNotFoundException {
        DBconnection dbc = new DBconnection();
        dbc.deleteStaff(id);

    }



}
