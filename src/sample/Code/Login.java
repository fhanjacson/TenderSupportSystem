package sample.Code;

import sample.Main;

import java.util.ArrayList;

public class Login {
    private String loggedin_username;
    private String loggedin_name;
    private int loggedin_role;

    public Login() {}

    boolean Verify(String username, String password) {
        ArrayList<String> list;
        int role;
        String dbusername, dbpassword, name;
        try {
            DBconnection conn = new DBconnection();
            list = conn.executequery("Select * from tendersupportsystem.user WHERE tendersupportsystem.user.user_username = '" + username + "'");
            System.out.println(list.get(1)+ "\t" + list.get(2) + "\t" + list.get(3) + "\t" + list.get(4));
            dbusername = list.get(1);
            dbpassword = list.get(2);
            role = Integer.parseInt(list.get(3));
            name = list.get(4);

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
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }


    public void setLoggedin_username(String loggedin_username){
        this.loggedin_username = loggedin_username;
    }
    public void setLoggedin_name(String loggedin_name){
        this.loggedin_name = loggedin_name;
    }
    public void setLoggedin_role(int loggedin_role){
        this.loggedin_role = loggedin_role;
    }

    public String getLoggedin_username(){
        return loggedin_username;
    }
    public String getLoggedin_name() {
        return loggedin_name;
    }
    public int getLoggedin_role(){
        return  loggedin_role;
    }
}
