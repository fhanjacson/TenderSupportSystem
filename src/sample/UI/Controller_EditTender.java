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
import sample.Code.Tender;
import sample.Code.misc;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class Controller_EditTender {
    public Button btnUpdate;
    public Button btnCancel;
    @FXML
    TextField txt_name;
    public TextField txt_total_amount;
    public TextField txt_id;
    public TextField txt_status;
    public DatePicker datepicker_deadline;
    public Button btnDelete;

    public void showForm() throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Controller_Menu.class.getResource("UI_EditTender.fxml"));
        primaryStage.setTitle("Tender Support System");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }

    @FXML
    void updateTender() throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_id.getText().trim();
        String name = txt_name.getText().trim();
        LocalDate deadline = datepicker_deadline.getValue();
        String strdeadline = null;
        Double total = null;
        String strtotal = txt_total_amount.getText().trim();
        String status = txt_status.getText().trim();
        try {
            if(datepicker_deadline.getValue() != null){
                strdeadline = datepicker_deadline.getValue().toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(misc.isDouble(strtotal)){
            total = Double.parseDouble(strtotal);
            System.out.println("total is number");
        }
        else{
            System.out.println("total is not number");
        }

        if(misc.isInteger(strid)){
            id = Integer.parseInt(strid);
            System.out.println("id is number");
        }
        else{
            System.out.println("id is not number");
        }

        if (total != null && deadline != null && !(name.isEmpty()) && !(deadline.toString().isEmpty()) && !(total.toString().isEmpty()) && !(status.toString().isEmpty())) {
            if(misc.isDate(strdeadline)) {
                if (misc.isInteger(strid)) {
                    if (misc.isDouble(strtotal)) {
                            Manager.updateTender(id, name, deadline, total, status);
                            getPrimaryStage().close();
                        } else {misc.msgBox("Update Tender", "Error", "Status is not number");}
                    } else {misc.msgBox("Update Tender", "Error", "Total is not number");}
                } else {misc.msgBox("Update Tender", "Error", "ID is not number");}
            }else{misc.msgBox("Update Tender", "Error", "Data is not valid");}
    }

    @FXML
    void delete(){
        Integer id = null;
        String strid = txt_id.getText().trim();

        try {
            if(misc.isInteger(strid)){
                id = Integer.parseInt(strid);
                System.out.println("id is number");
            }
            else{
                System.out.println("id is not number");
            }
            Manager.deleteTender(id);
            getPrimaryStage().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    Stage getPrimaryStage(){
        return (Stage) (txt_id.getScene().getWindow());
    }

    @FXML
    void cancel(){
        getPrimaryStage().close();
    }

    @FXML
    void search() throws SQLException, ClassNotFoundException {
        Integer id = null;
        String strid = txt_id.getText().trim();
        if(misc.isInteger(strid)){
            id = Integer.parseInt(strid);
            System.out.println("id is number");
        }
        else{
            System.out.println("id is not number");
            misc.msgBox("Update Tender","Error", "ID is not valid");
        }
        Tender tender = Manager.searchTender(id);
        try{
            txt_name.setText(tender.getTender_name());
            datepicker_deadline.setValue(tender.getTender_deadline());
            txt_total_amount.setText(String.valueOf(tender.getTender_total_amount()));
            txt_status.setText(tender.getTender_status());
        }catch (Exception e){
            misc.msgBox("Update Tender","Error", "ID is not valid");
        }

        if(txt_name.getText() == null ){
            txt_name.setText("INVALID ID");
            txt_total_amount.setText("INVALID ID");
            txt_status.setText("INVALID ID");
        }


    }
}


