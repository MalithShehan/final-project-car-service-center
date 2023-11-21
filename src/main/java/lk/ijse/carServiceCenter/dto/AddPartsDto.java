package lk.ijse.carServiceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddPartsDto {
    private String itemId;
    private String itemName;
    private double itemPrice;
    private int quantity;

}
