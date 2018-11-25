package sample.Code;

import sample.Main;

import java.sql.SQLException;
import java.util.ArrayList;

public class Login{
    private String loggedin_username;
    private String loggedin_name;
    private Integer loggedin_role;

    public Login() {}

    boolean Verify(String username, String password) {
        ArrayList<String> list;
        Integer role;
        String dbusername, dbpassword, name;
        try {
            DBconnection conn = new DBconnection();
            Staff staff = new Staff();
            staff = conn.readLoginDetail("Select * from tendersupportsystem.user WHERE tendersupportsystem.user.user_username = '" + username + "'");

            dbusername = staff.getUsername();
            dbpassword = staff.getPassword();
            role = staff.getUserRole();
            name = staff.getName();

            if (username.equals(dbusername) && password.equals(dbpassword)) {
                System.out.println("Logged In!");
                Main.login.setLoggedin_username(dbusername);
                Main.login.setLoggedin_name(name);
                Main.login.setLoggedin_role(role);
                System.out.println(Main.login.getLoggedin_role());
                return true;
            } else {
                System.out.println("Fail");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void log(String user, String action, String detail){
        System.out.println(user + " " + action + " " + detail);

        try {
            DBconnection dbc = new DBconnection();
            dbc.log(user, action, detail);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void setLoggedin_username(String loggedin_username){
        this.loggedin_username = loggedin_username;
    }
    public void setLoggedin_name(String loggedin_name){
        this.loggedin_name = loggedin_name;
    }
    public void setLoggedin_role(Integer loggedin_role){
        this.loggedin_role = loggedin_role;
    }

    public String getLoggedin_username(){
        return loggedin_username;
    }
    public String getLoggedin_name() {
        return loggedin_name;
    }
    public Integer getLoggedin_role(){
        return  loggedin_role;
    }
}
