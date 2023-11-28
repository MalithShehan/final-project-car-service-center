package lk.ijse.carServiceCenter.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailsTm {
    private String customerName;
    private String customerNIC;
    private String repairType;
    private double repairPrice;
    private String partName;
    private double partPrice;
    private int total;

    public DetailsTm(String customerName, String customerNIC, String repairType, double repairPrice, String partName, double partPrice) {
        this.customerName = customerName;
        this.customerNIC = customerNIC;
        this.repairType = repairType;
        this.repairPrice = repairPrice;
        this.partName = partName;
        this.partPrice = partPrice;
        this.total = (int) calculateTotal(repairPrice, partPrice);  // Convert the result to int
    }
    private double calculateTotal(double repairPrice, double partPrice) {
        return repairPrice + partPrice;
    }
}
