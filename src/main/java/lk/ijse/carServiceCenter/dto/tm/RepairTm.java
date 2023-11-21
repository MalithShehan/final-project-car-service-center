package lk.ijse.carServiceCenter.dto.tm;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RepairTm {
    private String repairId;
    private String repairType;
    private double repairPrice;
    private String customerNIC;

}
