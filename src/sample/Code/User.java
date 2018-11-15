package sample.Code;


import sample.Main;

public class User {
    private int user_index;
    private String user_username;
    private String user_password;
    private int user_role;
    private String user_contact;
    private String user_address;

    public User(){}

    public boolean signin() {

        return Main.login.Verify(this.getUsername(), this.getPassword());
    }


    public void setUserIndex(int userindex){this.user_index = userindex;}
    public void setUsername(String username) {this.user_username = username;}
    public void setPassword(String password) {this.user_password = password;}
    public void setUserRole(int role) {this.user_role = role;}
    public void setUserContact(String contact) {this.user_contact = contact;}
    public void setUserAddress(String address) {this.user_address = address;}

    public int getUserIndex() {return user_index;}
    public String getUsername() {return user_username;}
    public String getPassword() {return user_password;}
    public int getUserRole() {return user_role;}
    public String getUserContact() {return user_contact;}
    public String getUserAddress() {return user_address;}


}
