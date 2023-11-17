package lk.ijse.carServiceCenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BookingDto {
    private String bookId;
    private String bookType;
    private String customerNIC;
    private Date date;
}
