package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class RepairTableFormController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colRepairID;

    @FXML
    private TableColumn<?, ?> colRepairPrice;

    @FXML
    private TableColumn<?, ?> colRepairType;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private AnchorPane repairTable;

    @FXML
    private TableView<?> repairTableView;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            repairTable.getChildren().clear();
            repairTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repair_car_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
