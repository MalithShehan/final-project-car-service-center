package lk.ijse.carServiceCenter.dto.tm;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingTm {
    private String bookId;
    private String bookType;
    private String customerNIC;
    private Date date;
}
