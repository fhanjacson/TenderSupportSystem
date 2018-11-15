package sample;
//#C0C0C0 Background
//#4b4b4c Text
//TODO https://code.makery.ch/blog/javafx-dialogs-official/

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Code.Login;
import sample.UI.*;
import java.io.IOException;

public class Main extends Application {

    public static Login login = new Login();


    public void start(Stage stage) throws IOException{  
        Controller_Login ControllerLogin = new Controller_Login();
        ControllerLogin.gotoLogin();

    }
}
