package lk.ijse.carServiceCenter.dto.tm;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddPartsTm  {
    private String itemId;
    private String itemName;
    private double itemPrice;
    private int quantity;
}
