package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.util.Objects;

public class RepairCarFormController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnAddParts;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnViewRepairTable;

    @FXML
    private FontIcon dashBordBtn;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private AnchorPane repairCar;

    @FXML
    private TextField textID;

    @FXML
    private TextField textRepairType;

    @FXML
    private JFXComboBox<?> txtNIC;

    @FXML
    private TextField txtRepaiPrice;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddPartsOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewRepairTableOnAction(ActionEvent event) {
        try {
            repairCar.getChildren().clear();
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/view_repair_table.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        try {
            repairCar.getChildren().clear();
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
