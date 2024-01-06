package lk.ijse.carServiceCenter.entity;


import java.sql.Date;



public class Booking {
    private String bookId;
    private String bookType;
    private String customerNIC;

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookType() {
        return bookType;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public Date getDate() {
        return date;
    }

    public Booking(String bookId, String bookType, String customerNIC, Date date) {
        this.bookId = bookId;
        this.bookType = bookType;
        this.customerNIC = customerNIC;
        this.date = date;
    }

    private Date date;
}
