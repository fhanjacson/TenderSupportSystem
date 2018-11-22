package sample.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_Report {
    private static Stage primaryStage = new Stage();

    void showForm() throws IOException {

        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Report.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
