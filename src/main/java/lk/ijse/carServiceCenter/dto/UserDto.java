package lk.ijse.carServiceCenter.dto;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDto {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
