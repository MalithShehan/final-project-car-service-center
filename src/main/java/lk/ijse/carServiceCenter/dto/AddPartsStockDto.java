package lk.ijse.carServiceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddPartsStockDto {
    private String itemId;
    private String partName;
    private String partPrice;
    private int qtyOnHand;

}
