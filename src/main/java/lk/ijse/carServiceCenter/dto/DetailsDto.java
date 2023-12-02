package lk.ijse.carServiceCenter.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailsDto {
    private String customerName;
    private String customerNIC;
    private String repairType;
    private double repairPrice;
    private String partName;
    private double partPrice;
}
