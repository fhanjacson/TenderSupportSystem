package sample.Code;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class misc {

    public static void msgBox(String Title, String Header, String Content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(Title);
        alert.setHeaderText(Header);
        alert.setContentText(Content);
        alert.showAndWait();
    }

    public static boolean isInteger(String str) {
        if(str == null || str.trim().isEmpty()) {return false;}
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {return false;}
        }
        return true;
    }

    public static boolean isDouble(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isDate(String str){
        try{
            LocalDate.parse(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}