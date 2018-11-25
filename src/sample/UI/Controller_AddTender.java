package sample.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Code.Manager;
import sample.Code.misc;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class Controller_AddTender {

    @FXML
    TextField txt_name, txt_total_amount, txt_status;
    @FXML
    DatePicker datepicker_deadline;
    @FXML
    Button btnCancel;

    public void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_AddTender.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.showAndWait();
    }

    Stage getPrimaryStage(){return (Stage) (txt_name.getScene().getWindow());}

    @FXML
    void addNewTender() throws SQLException, ClassNotFoundException {
        String name = txt_name.getText().trim();
        LocalDate dateDeadline = null;
        String strdeadline = null;
        Double total = null;
        String strtotal = txt_total_amount.getText().trim();;
        String status = txt_status.getText().trim();

        if(datepicker_deadline.getValue() != null){
            strdeadline = datepicker_deadline.getValue().toString();
            if(misc.isDate(strdeadline)){
                dateDeadline = datepicker_deadline.getValue();
            }else{System.out.println("Deadline is valid");}
        }else{System.out.println("Date picker is empty");}

        if(misc.isDouble(strtotal)){
            total = Double.parseDouble(strtotal);
            System.out.println("price is number");
        }else{System.out.println("price not number");}

        if(!(name.isEmpty())){
            if(strdeadline != null && misc.isDate(strdeadline)){
                if(!(strtotal.isEmpty()) && misc.isDouble(strtotal)){
                    if(!(status.isEmpty())){
                        Manager.addNewTender(name, dateDeadline, 0.00, status);
//                        Manager.addNewTender(name, dateDeadline, total, status);
                        getPrimaryStage().close();
                        System.out.println("Tender Added");
                    }else{misc.msgBox("Update Product","Error", "Status is not valid");}
                }else{misc.msgBox("Update Product","Error", "Total is not valid");}
            }else{misc.msgBox("Update Product","Error", "Deadline is not valid");}
        }else{misc.msgBox("Update Product","Error", "Name is not valid");}
    }

    @FXML
    private void cancel(){getPrimaryStage().close();}
}

