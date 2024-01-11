package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.bo.BOFactory;
import lk.ijse.carServiceCenter.bo.custom.RepairBO;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.RepairDto;
import lk.ijse.carServiceCenter.model.AddCustomerModel;
import lk.ijse.carServiceCenter.model.AddPartsModel;
import lk.ijse.carServiceCenter.model.RepairModel;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

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
    private JFXComboBox<String> txtNIC;

    @FXML
    private TextField txtRepaiPrice;

    private final AddCustomerModel addCustomerModel = new AddCustomerModel();

    RepairBO repairBO = (RepairBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REPAIR);

    public void initialize() {
        loadCustomerNICs();
    }

    private void loadCustomerNICs() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<AddCustomerDto> cusList = AddCustomerModel.loadAllCustomers();

            for (AddCustomerDto dto : cusList) {
                obList.add(dto.getCustomerNIC());
            }
            txtNIC.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String repairId = textID.getText();
        String repairType = textRepairType.getText();
        double repairPrice = Double.parseDouble(txtRepaiPrice.getText());
        String customerNIC = txtNIC.getValue();
        if (customerNIC == null || customerNIC.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select a customer NIC").show();
            return;
        }

        var repairDto = new RepairDto(repairId, repairType, repairPrice, customerNIC);

        var model = new RepairModel();

        try {
            boolean isRepairCarValidated = validateRepair();
            if (isRepairCarValidated) {
                boolean isSaved = repairBO.saveRepair(repairDto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Repair Saved!").show();
                    clearField();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean validateRepair() {
        String repairId = textID.getText();
        double repairPrice = Double.parseDouble(txtRepaiPrice.getText());

        boolean isRepairIdValidate = Pattern.matches("R\\d{3}", repairId);
        if (!isRepairIdValidate) {
            new Alert(Alert.AlertType.ERROR, "Invalid Repair ID!").show();
            return false;
        }
        return true;
    }

    private void clearField() {
        textID.setText("");
        textRepairType.setText("");
        txtRepaiPrice.setText("");
    }

    @FXML
    void btnAddPartsOnAction(ActionEvent event) {
        try {
            repairCar.getChildren().clear();
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_parts_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearField();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String repairId = textID.getText();

        var repairModel = new RepairModel();

        repairBO.deleteRepair(repairId);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String repairId = textID.getText();
        String repairType = textRepairType.getText();
        double repairPrice = Double.parseDouble(txtRepaiPrice.getText());
        String customerNIC = txtNIC.getValue();
        if (customerNIC == null || customerNIC.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select a customer NIC").show();
            return;
        }
         var dto = new RepairDto(repairId, repairType, repairPrice, customerNIC);

        var model = new RepairModel();

        try {
            boolean isValidated = validateRepair();
            if (isValidated){
                boolean isUpdated = repairBO.updateRepair(dto);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Repair Table Is Updated!").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public void comboBoxNic(ActionEvent actionEvent) throws SQLException {
        String customerNIC = txtNIC.getValue();

        AddCustomerDto dto = addCustomerModel.searchCustomer(customerNIC);

    }
}
