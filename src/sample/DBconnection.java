package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnection {
    private String sqlQuery;

    public DBconnection(String sqlQuery) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public void setSqlQuery(String sqlQuery){
        this.sqlQuery = sqlQuery;
    }
}
