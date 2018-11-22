package sample.Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Logging {
    public static void log(String user, String action, String detail){
        System.out.println(user + " " + action + " " + detail);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");;
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO tendersupportsystem.log (log_user, log_action, log_time, log_date, log_detail) VALUES ('" + user + "', '" + action + "' , '" + java.time.LocalTime.now() + "' , '"+ java.time.LocalDate.now() +"', '"+ detail +"')");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
}
