package lk.ijse.carServiceCenter.dto.tm;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class DetailsTm {
    private String customerName;
    private String customerNIC;
    private String repairType;
    private double repairPrice;
    private String partName;
    private double partPrice;
    private double total;
    private Button button;

//    public DetailsTm(String customerName, String customerNIC, String repairType, double repairPrice, String partName, double partPrice, double v, JFXButton jfxButton) {
//        this.customerName = customerName;
//        this.customerNIC = customerNIC;
//        this.repairType = repairType;
//        this.repairPrice = repairPrice;
//        this.partName = partName;
//        this.partPrice = partPrice;
//        this.total = v;
//        this.button = jfxButton;
//    }
}
