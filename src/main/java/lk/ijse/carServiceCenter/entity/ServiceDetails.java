package lk.ijse.carServiceCenter.entity;

public class ServiceDetails {
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public void setRepairPrice(double repairPrice) {
        this.repairPrice = repairPrice;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public String getRepairType() {
        return repairType;
    }

    public double getRepairPrice() {
        return repairPrice;
    }

    public String getPartName() {
        return partName;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public ServiceDetails(String customerName, String customerNIC, String repairType, double repairPrice, String partName, double partPrice) {
        this.customerName = customerName;
        this.customerNIC = customerNIC;
        this.repairType = repairType;
        this.repairPrice = repairPrice;
        this.partName = partName;
        this.partPrice = partPrice;
    }

    private String customerName;
    private String customerNIC;
    private String repairType;
    private double repairPrice;
    private String partName;
    private double partPrice;
}
