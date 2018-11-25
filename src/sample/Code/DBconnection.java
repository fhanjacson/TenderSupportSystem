package sample.Code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DBconnection {

    private Connection connection;

    private static String getDBDriver(){
        return "com.mysql.cj.jdbc.Driver";
    }
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/tendersupportsystem?serverTimezone=UTC", "user", "1234");
    }
    private static Statement getStatement() throws SQLException, ClassNotFoundException {
        Class.forName(getDBDriver());
        return  DBconnection.getConnection().createStatement();
    }
    DBconnection() throws SQLException, ClassNotFoundException {
        Class.forName(getDBDriver());
        connection = getConnection();
    }


    //System Admin
    ObservableList<Staff> viewStaff(){
        ObservableList<Staff> staffdetail = FXCollections.observableArrayList();
        try {
            Class.forName(getDBDriver());
            ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM tendersupportsystem.user");
            while (rs.next()) {
                staffdetail.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            getConnection().close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return staffdetail;
    }

    Staff searchStaff(Integer id){
        Staff staff = new Staff();
        try {
            Class.forName(DBconnection.getDBDriver());
            Connection con = DBconnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.user WHERE user_index = '" + id + "'");
            while (rs.next()) {
                staff.setUsername(rs.getString(2));
                staff.setPassword(rs.getString(3));
                staff.setUserRole(rs.getInt(4));
                staff.setName(rs.getString(5));
                staff.setUserContact(rs.getString(6));
                staff.setUserAddress(rs.getString(7));
            }
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return staff;
    }
    void addStaff(String username, String password, Integer role, String name, String contact, String address) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        stmt.executeUpdate("INSERT INTO tendersupportsystem.user ( user_username, user_password, user_role_id, user_name, user_contact_number, user_address) VALUES ('" + username + "', '" + password + "' , '" + role + "' , '"+ name +"', '"+ contact +"', '"+ address +"')");
        getConnection().close();
    }
    void updateStaff(Integer id, String username, String password, Integer role, String name, String contact, String address) throws SQLException, ClassNotFoundException {
        Statement stmt = getStatement();
        String sql = "UPDATE tendersupportsystem.user SET user_username='"+ username +"', user_password='" + password + "', user_role_id='" + role + "', user_name='" + name + "', user_contact_number='" + contact +"', user_address='" + address +"' where user_index='" + id +"'";
        int updateCount = stmt.executeUpdate(sql);
        System.out.println("Update Status: " + updateCount);
    }
    void deleteStaff(Integer id) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "DELETE FROM tendersupportsystem.user where user_index='"+ id+"'";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }

    //LOGIN
    Staff readLoginDetail(String sqlQuery){
        Staff staff = new Staff();
        try {
            Class.forName(getDBDriver());
            Connection con = getConnection();
            ResultSet rs = con.createStatement().executeQuery(sqlQuery);
            while (rs.next()) {
                staff.setUserIndex(rs.getInt(1)); //index
                staff.setUsername(rs.getString(2)); //username
                staff.setPassword(rs.getString(3)); //password
                staff.setUserRole(rs.getInt(4)); // role
                staff.setName(rs.getString(5)); //name
                staff.setUserContact(rs.getString(6)); //contact
                staff.setUserAddress(rs.getString(7)); //address
            }
            con.close();
        }catch (Exception e) {e.printStackTrace();}
        return staff;
    }


    //Manager
    ObservableList<Product> viewProduct(){
        ObservableList<Product> productdetail = FXCollections.observableArrayList();
        try {
            Class.forName(getDBDriver());
            ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM tendersupportsystem.product");
            while (rs.next()) {
                productdetail.add(new Product(rs.getInt("Product_ID"), rs.getString("Product_Name"), rs.getString("Product_Material"), rs.getString("Product_Category"), rs.getDouble("Product_Price"), rs.getDouble("Product_Discount"), rs.getDouble("Product_MarkUp"), rs.getDouble("Product_LabourCost")));
            }
            getConnection().close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return productdetail;
    }

    Product searchProduct(Integer id) {
        Product product = new Product();
        try{
            Class.forName(DBconnection.getDBDriver());
            Connection con = DBconnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.product WHERE Product_ID = '" + id + "'");
            while (rs.next()){
                product.setProduct_name(rs.getString(2));
                product.setProduct_material(rs.getString(3));
                product.setProduct_category(rs.getString(4));
                product.setProduct_price(rs.getDouble(5));
                product.setProduct_discount(rs.getDouble(6));
                product.setProduct_markup(rs.getDouble(7));
                product.setProduct_labourcost(rs.getDouble(8));
            }
        }catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return product;
    }
    void addNewProduct(String name, String material, String category, Double price, Double discount, Double markup, Double labourcost) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        stmt.executeUpdate("INSERT INTO tendersupportsystem.product (Product_Name, Product_Material, Product_Category, Product_Price, Product_Discount, Product_MarkUp, Product_LabourCost) VALUES ('" + name + "', '" + material + "' , '" + category + "' , '"+ price +"', '"+ discount + "' , '" + markup +"' , '" + labourcost +"')");
        getConnection().close();
    }
    void updateProduct(Integer id, String name, String material, String category, Double price, Double discount, Double markup, Double labourcosst) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "UPDATE tendersupportsystem.product SET Product_Name='"+ name +"', Product_Material='" + material + "', Product_Category='" + category + "', Product_Price='" + price +"', Product_Discount='" + discount + "', Product_MarkUp='"+markup+"', Product_LabourCost='"+labourcosst+"' where Product_ID='" + id +"'";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();

    }
    void deleteProduct(Integer id) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "DELETE FROM tendersupportsystem.product where id='"+ id+"'";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }

    //Manager
    ObservableList<Tender> viewTender() {
        ObservableList<Tender> tenderdetail = FXCollections.observableArrayList();
        try {
            Class.forName(getDBDriver());
            ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM tendersupportsystem.tender");
            while (rs.next()) {
                tenderdetail.add(new Tender(rs.getInt(1), rs.getString(2), rs.getDate(3), LocalDate.parse(rs.getDate(4).toString()), rs.getDouble(5), rs.getString(6)));
            }
            getConnection().close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return tenderdetail;
    }
    Tender searchTender(Integer id) {
        Tender tender = new Tender();
        try {
            Class.forName(DBconnection.getDBDriver());
            Connection con = DBconnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM tendersupportsystem.tender WHERE id = '" + id + "'");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                tender.setTender_name(rs.getString(2));
                tender.setTender_deadline(LocalDate.parse(rs.getDate(4).toString()));
                tender.setTender_total_amount(rs.getDouble(5));
                tender.setTender_status(rs.getString(6));
            }
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return tender;
    }
    void addNewTender(String name, LocalDate deadline, Double total_amount, String status) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "INSERT INTO tendersupportsystem.tender (name, date_created, date_deadline, total_amount, status) VALUES ('" + name + "', '" + java.time.LocalDate.now() + "' , '" + deadline + "' , '"+ total_amount + "' , '" + status + "')";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }
    void updateTender(Integer id, String name, LocalDate deadline, Double total_amount, String status) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "UPDATE tendersupportsystem.tender SET name='"+ name +"', date_deadline='" + deadline + "', total_amount='" + total_amount + "', status='" + status +"' where id='" + id +"'";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }
    void deleteTender(Integer id) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "Delete FROM tendersupportsystem.tender where id='"+ id+"'";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }

    //LOGGING
    void log(String user, String action, String detail) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "INSERT INTO tendersupportsystem.log (log_user, log_action, log_time, log_date, log_detail) VALUES ('" + user + "', '" + action + "' , '" + java.time.LocalTime.now() + "' , '"+ java.time.LocalDate.now() +"', '"+ detail +"')";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }


    //TENDER PRODUCT
    ObservableList<TenderProduct> viewTenderProduct() {
        ObservableList<TenderProduct> tenderproductdetail = FXCollections.observableArrayList();
        try {
            Class.forName(getDBDriver());
            ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM tendersupportsystem.tender_product");
            while (rs.next()) {
                tenderproductdetail.add(new TenderProduct(rs.getInt(1), rs.getInt(2)));
            }
            getConnection().close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return tenderproductdetail;
    }

    void addProductToTender(Integer tenderID, Integer productID) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "INSERT INTO tendersupportsystem.tender_product (Tender_ID, Product_ID) VALUES ('" + tenderID + "', '" + productID + "')";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }

    void calculateTenderTotalAmount(Integer id) throws SQLException, ClassNotFoundException {
        Statement stmt = DBconnection.getStatement();
        String sql = "UPDATE tender SET tender.total_amount =(Select SUM(Product_Price - Product_Discount + Product_MarkUp +  Product_LabourCost) from product where Product_ID in (select Product_ID from tender_product where Tender_ID='"+ id +"')) where id='"+ id +"'";
        int sqlResult = stmt.executeUpdate(sql);
        System.out.println("SQL Result: "+sqlResult);
        getConnection().close();
    }

    ObservableList<TenderProduct> viewDetailedTenderProduct() {
        ObservableList<TenderProduct> tenderproductdetail = FXCollections.observableArrayList();
        try {
            Class.forName(getDBDriver());
            ResultSet rs = getConnection().createStatement().executeQuery("select Tender_ID, tender_product.Product_ID, Product_Name, Product_Material, Product_Category, Product_Price, Product_Discount, Product_MarkUp, Product_LabourCost, total_amount from (( tender_product inner JOIN product on product.Product_ID = tender_product.Product_ID) inner join tender on tender.id = tender_product.Tender_ID)");
            while (rs.next()) {
                tenderproductdetail.add(new TenderProduct(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10)));
            }
            getConnection().close();
        } catch (ClassNotFoundException | SQLException e) {e.printStackTrace();}
        return tenderproductdetail;
    }
}
