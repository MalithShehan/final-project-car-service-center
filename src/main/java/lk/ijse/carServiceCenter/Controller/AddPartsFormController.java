package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class AddPartsFormController {

    @FXML
    private AnchorPane addParts;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnViewRepairTable;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TextField textItemId;

    @FXML
    private TextField textItemName;

    @FXML
    private TextField textItemPrice;

    @FXML
    private TextField textQuantity;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            addParts.getChildren().clear();
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repair_car_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        @FXML
    void btnAddOnAction(ActionEvent event) {

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
            addParts.getChildren().clear();
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/view_parts_table.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
