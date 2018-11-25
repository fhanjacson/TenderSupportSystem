package sample.Code;


import sample.Main;
import sample.UI.Controller_Login;

import java.io.IOException;

public class Staff {
    private Integer user_index;
    private String user_username;
    private String user_password;
    private Integer user_role;
    private String user_name;
    private String user_contact;
    private String user_address;

    public Staff(){}
    public Staff(Integer index, String username, String password, Integer role, String name, String contact, String address){
        this.user_index = index;
        this.user_username = username;
        this.user_password = password;
        this.user_role = role;
        this.user_name = name;
        this.user_contact = contact;
        this.user_address = address;
    }

    public boolean signin() {
        return Main.login.Verify(this.getUsername(), this.getPassword());
    }

    public static void signout() throws IOException {
        Login.log(Main.login.getLoggedin_username(), "Logout", "");
        Controller_Login ControllerLogin = new Controller_Login();
        ControllerLogin.gotoLogin();


    }

    public void setUserIndex(Integer userindex){this.user_index = userindex;}
    public void setUsername(String username) {this.user_username = username;}
    public void setPassword(String password) {this.user_password = password;}
    public void setUserRole(Integer role) {this.user_role = role;}
    public void setName(String name) {this.user_name = name;}
    public void setUserContact(String contact) {this.user_contact = contact;}
    public void setUserAddress(String address) {this.user_address = address;}

    public Integer getUserIndex() {return user_index;}
    public String getUsername() {return user_username;}
    public String getPassword() {return user_password;}
    public Integer getUserRole() {return user_role;}
    public String getName() {return user_name;}
    public String getUserContact() {return user_contact;}
    public String getUserAddress() {return user_address;}


}
