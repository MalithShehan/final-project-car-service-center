package lk.ijse.carServiceCenter.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddCustomerDto {
    private String customerNIC;
    private String customerName;
    private String address;
    private String tel;
    private String email;
    private Date date;


}
