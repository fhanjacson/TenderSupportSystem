package sample.Code;

import java.time.LocalDate;
import java.util.Date;

public class Tender {
    private Integer tender_id;
    private String tender_name;
    private Date tender_date_created;
    private LocalDate tender_deadline;
    private double tender_total_amount;
    private String tender_status;

    public Tender(Integer tender_id, String tender_name, Date tender_date_created, LocalDate tender_deadline, double tender_total_amount, String tender_status) {
        this.tender_id = tender_id;
        this.tender_name = tender_name;
        this.tender_date_created = tender_date_created;
        this.tender_deadline = tender_deadline;
        this.tender_total_amount = tender_total_amount;
        this.tender_status = tender_status;
    }
    public Tender(){

    }

    public Integer getTender_id() {
        return tender_id;
    }
    public void setTender_id(Integer tender_id) {
        this.tender_id = tender_id;
    }

    public String getTender_name() {
        return tender_name;
    }
    public void setTender_name(String tender_name) {
        this.tender_name = tender_name;
    }

    public Date getTender_date_created() {
        return tender_date_created;
    }
    public void setTender_date_created(Date tender_date_created) {
        this.tender_date_created = tender_date_created;
    }

    public LocalDate getTender_deadline() {
        return tender_deadline;
    }
    public void setTender_deadline(LocalDate tender_deadline) {
        this.tender_deadline = tender_deadline;
    }

    public double getTender_total_amount() {
        return tender_total_amount;
    }
    public void setTender_total_amount(double tender_total_amount) {
        this.tender_total_amount = tender_total_amount;
    }

    public String getTender_status() {
        return tender_status;
    }
    public void setTender_status(String tender_status) {
        this.tender_status = tender_status;
    }





}
