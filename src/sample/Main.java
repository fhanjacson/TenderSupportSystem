package sample;
//#C0C0C0 Background
//#4b4b4c Text
//TODO https://code.makery.ch/blog/javafx-dialogs-official/
//TODO https://stackoverflow.com/questions/40519580/trying-to-determine-if-a-string-is-an-integer?rq=1
//TODO Implement Object Oriented ;  Encapsulation, Abstraction, Inheritance, Polymorphism implements interface
//TODO Manager: can go back to main form | No duplication of tender is allowed
//TODO SysAdmin: No duplication of staff allowed
//TODO Product: (discount, markup, labour cost) | PRODUCT TYPE, MODEL
//TODO Tender: total amount = price (product) + discount + mark-up + labour cost | Change status to string pending, in progress, submitted
//TODO Officer: Search product by brand model and type, add product to tender list, Compute tender total price
//TODO Material Specification: body, disc, cover, pin, connection standard, pressure, and approval | Relationship to Product [Material ID & Product ID]

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
