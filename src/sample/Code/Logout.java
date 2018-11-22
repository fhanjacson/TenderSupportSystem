package sample.Code;

import javafx.stage.Stage;
import sample.Main;
import sample.UI.Controller_Login;

import java.io.IOException;

public class Logout {
    private static Stage primaryStage = new Stage();

    public static void logout() throws IOException {
        Logging.log(Main.login.getLoggedin_username(), "Log out", "");
        Controller_Login ControllerLogin = new Controller_Login();
        ControllerLogin.gotoLogin();


    }
}
