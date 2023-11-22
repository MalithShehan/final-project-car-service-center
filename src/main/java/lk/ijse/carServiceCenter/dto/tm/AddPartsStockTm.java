package lk.ijse.carServiceCenter.dto.tm;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddPartsStockTm {
    private String itemId;
    private String partName;
    private String partPrice;
    private int qtyOnHand;

}
