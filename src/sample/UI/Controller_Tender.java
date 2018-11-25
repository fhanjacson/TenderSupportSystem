package sample.UI;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Code.Manager;
import sample.Code.Tender;
import java.io.IOException;
import java.sql.SQLException;

public class Controller_Tender {

    private ObservableList<Tender> tenderdetail;
    @FXML
    Button buttonAdd, buttonEdit;
    @FXML
    TableView<Tender> tableView;
    @FXML TableColumn<Tender, Integer> Column1;
    @FXML TableColumn<Tender, String> Column2;
    @FXML TableColumn<Tender, String> Column3;
    @FXML TableColumn<Tender, String> Column4;
    @FXML TableColumn<Tender, Double> Column5;
    @FXML TableColumn<Tender, String> Column6;

    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        Column1.setCellValueFactory(new PropertyValueFactory<>("Tender_id"));
        Column2.setCellValueFactory(new PropertyValueFactory<>("Tender_name"));
        Column3.setCellValueFactory(new PropertyValueFactory<>("Tender_date_created"));
        Column4.setCellValueFactory(new PropertyValueFactory<>("Tender_deadline"));
        Column5.setCellValueFactory(new PropertyValueFactory<>("Tender_total_amount"));
        Column6.setCellValueFactory(new PropertyValueFactory<>("Tender_status"));

        tenderdetail = Manager.viewTender();
        tableView.setItems(tenderdetail);
    }

    Stage getPrimaryStage(){return (Stage) (buttonAdd.getScene().getWindow());}

    void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_Tender.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void refreshTable() throws SQLException, ClassNotFoundException {
        tableView.setItems(null);
        tenderdetail.clear();
        tenderdetail = Manager.viewTender();
        tableView.setItems(tenderdetail);
    }

//    public void gotoLogin() throws IOException {
//        Staff.signout();
//        getPrimaryStage().close();
//    }

    public void add() throws IOException {
        Controller_AddTender addtender = new Controller_AddTender();
        addtender.showForm();
    }

    public void edit() throws IOException {
        Controller_EditTender edittender = new Controller_EditTender();
        edittender.showForm();
    }

    public void gotoHome(ActionEvent actionEvent) throws IOException {
        Controller_Menu menugui = new Controller_Menu();
        menugui.showForm();
        getPrimaryStage().close();

    }


}
