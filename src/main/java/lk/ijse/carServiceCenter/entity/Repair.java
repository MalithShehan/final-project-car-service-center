package lk.ijse.carServiceCenter.entity;

public class Repair {
    private String repairId;
    private String repairType;
    private double repairPrice;
    private String customerNIC;

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public void setRepairPrice(double repairPrice) {
        this.repairPrice = repairPrice;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }

    public String getRepairId() {
        return repairId;
    }

    public String getRepairType() {
        return repairType;
    }

    public double getRepairPrice() {
        return repairPrice;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public Repair(String repairId, String repairType, double repairPrice, String customerNIC) {
        this.repairId = repairId;
        this.repairType = repairType;
        this.repairPrice = repairPrice;
        this.customerNIC = customerNIC;
    }
}
