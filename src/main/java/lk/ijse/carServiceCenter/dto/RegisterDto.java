package lk.ijse.carServiceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
