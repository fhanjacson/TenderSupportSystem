package sample.Code;

import java.sql.SQLException;

public class SystemAdmin {

    public SystemAdmin(){}

    public void addNewUser(String username, String password, Integer role, String name, String contact, String address){
        try {
            DBconnection dbc = new DBconnection();
            dbc.addNewUser(username, password, role, name,contact, address);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
