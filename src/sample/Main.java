package sample;
//#C0C0C0 Background
//#4b4b4c Text
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static Login login = new Login();

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        Parent root = FXMLLoader.load(getClass().getResource("UI_Login.fxml"));
//        primaryStage.setTitle("Tender Support System");
//        primaryStage.setScene(new Scene(root, 720, 480));
//        primaryStage.setResizable(false);
//        primaryStage.show();
//    }

//    public static void main(String[] args) throws IOException {
//        launch(args);
//        //Controller_Login.showLoginStage();
//
//    }

    public void start(Stage stage) throws IOException {
        Controller_Login.showStage();
    }
}
