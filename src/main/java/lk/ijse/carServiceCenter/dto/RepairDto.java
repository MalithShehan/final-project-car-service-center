package lk.ijse.carServiceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairDto {
    private String repairId;
    private String repairType;
    private double repairPrice;
    private String customerNIC;
}
