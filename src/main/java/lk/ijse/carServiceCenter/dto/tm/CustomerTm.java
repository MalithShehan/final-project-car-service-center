package lk.ijse.carServiceCenter.dto.tm;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerTm {
    private String customerNIC;
    private String customerName;
    private String address;
    private String tel;
    private String email;
    private Date date;
}
