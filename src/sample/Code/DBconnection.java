package sample.Code;

import java.sql.*;
import java.util.ArrayList;

public class DBconnection {


    public ArrayList<String> executequery(String sqlQuery) throws ClassNotFoundException, SQLException {
        ArrayList<String> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            ResultSet rs = con.createStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                list.add(Integer.toString(rs.getInt(1))); //index
                list.add(rs.getString(2)); //username
                list.add(rs.getString(3)); //password
                list.add(Integer.toString(rs.getInt(4))); // role
                list.add(rs.getString(5)); //name
                list.add(rs.getString(6)); //contact
                list.add(rs.getString(7)); //address
            }
        }catch (Exception e){
            list.add(e.toString());
            System.out.println(e);
        }
        return list;
    }
}