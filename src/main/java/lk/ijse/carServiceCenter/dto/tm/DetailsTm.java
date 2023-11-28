package lk.ijse.carServiceCenter.dto.tm;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceTm {
    private String customerName;
    private String customerNIC;
    private String repairType;
    private double repairPrice;
    private String partName;
    private double total;
}
