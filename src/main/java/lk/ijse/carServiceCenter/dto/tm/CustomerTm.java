package lk.ijse.carServiceCenter.dto.tm;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerTm {
    private String customerNIC;
    private String name;
    private String address;
    private String tel;
    private String email;
}
