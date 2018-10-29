package sample;

public class Login {
    private String loggedin_username;
    private String loggedin_name;
    private int  loggedin_role;

    public Login(){
        System.out.println("Object Created");
    }

    public Login(String loggedin_username, String loggedin_name, int loggedin_role){
        this.setLoggedin_username(loggedin_username);
        this.setLoggedin_name(loggedin_name);
        this.setLoggedin_role(loggedin_role);
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
