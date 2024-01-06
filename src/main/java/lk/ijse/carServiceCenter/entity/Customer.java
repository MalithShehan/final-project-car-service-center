package lk.ijse.carServiceCenter.entity;


import java.util.Date;

public class Customer {

    private String customerNIC;
    private String customerName;
    private String address;
    private String tel;
    private String email;
    private Date date;

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public Date getDate() {
        return date;
    }

    public Customer(String customerNIC, String customerName, String address, String tel, String email, Date date) {
        this.customerNIC = customerNIC;
        this.customerName = customerName;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.date = date;
    }
}
