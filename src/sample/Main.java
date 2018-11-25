package sample;
//#C0C0C0 Background
//#4b4b4c Text
//TODO https://code.makery.ch/blog/javafx-dialogs-official/
//TODO https://stackoverflow.com/questions/40519580/trying-to-determine-if-a-string-is-an-integer?rq=1
//TODO Implement Object Oriented;  Encapsulation, Abstraction, Inheritance, Polymorphism implements interface;
//TODO Relationship to Product [Material ID & Product ID]
//TODO Error handling on TenderList
//TODO Insert Real Data
//TODO Testing

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
