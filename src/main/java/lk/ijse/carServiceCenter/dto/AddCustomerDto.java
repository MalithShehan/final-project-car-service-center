package lk.ijse.carServiceCenter.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddCustomerDto {
    private String customerNIC;
    private String customerName;
    private String address;
    private String tel;
    private String email;


}
