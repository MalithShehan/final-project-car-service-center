package lk.ijse.carServiceCenter.dto;

import lk.ijse.carServiceCenter.dto.tm.AddPartsTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddPartsDto {
    private String itemId;
    private String itemName;
    private double itemPrice;
    private int quantity;
}


