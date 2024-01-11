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
import lk.ijse.carServiceCenter.bo.custom.PartsBO;
import lk.ijse.carServiceCenter.bo.custom.impl.PartsBOImpl;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.dto.tm.AddPartsTm;
import lk.ijse.carServiceCenter.model.AddPartsModel;
import lk.ijse.carServiceCenter.model.AddPartsStockModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class AddPartsFormController {

    private final AddPartsStockModel addPartsStockModel = new AddPartsStockModel();

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
    private JFXComboBox<String> txtPartId;

    PartsBOImpl partsBO = (PartsBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PARTS);

    public void initialize() {
        loadPartIds();
    }

    private void loadPartIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<AddPartsStockDto> partsList = AddPartsStockModel.loadAllPartsId();
        for (AddPartsStockDto dto : partsList) {
            obList.add(dto.getItemId());
        }
        txtPartId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private AddPartsModel addPartsModel = new AddPartsModel();
    private final ObservableList<AddPartsTm> obList = FXCollections.observableArrayList();


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
        String itemId = txtPartId.getValue();
        String itemName = textItemName.getText();
        double itemPrice = Double.parseDouble(textItemPrice.getText());
        int quantity = Integer.parseInt(textQuantity.getText());

            List<AddPartsTm> tmList = new ArrayList<>();

            for (AddPartsTm addPartsTm : obList) {
                tmList.add(addPartsTm);
            }


        try {
            boolean isAddPartsValidated = validateParts();
            if (isAddPartsValidated) {
                boolean isSaved = partsBO.savePart(new AddPartsDto(itemId, itemName, itemPrice, quantity));
                if (isSaved) {
                    AddPartsStockModel.delete(txtPartId.getValue(),textQuantity.getText());
                    new Alert(Alert.AlertType.CONFIRMATION, "Item Saved Successfully!").show();
                    clarField();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        }

    private boolean validateParts() {
        String itemId = txtPartId.getValue();
        int quantity = Integer.parseInt(textQuantity.getText());

        boolean isItemIdValidated = Pattern.matches("I\\d{3}", itemId);
        if (!isItemIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Item ID!").show();
            return false;
        }
        return true;
    }

    private void clarField() {
        textItemName.setText("");
        textItemPrice.setText("");
        textQuantity.setText("");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clarField();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String itemId = textItemId.getText();

       partsBO.deletePart(itemId);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String itemId = textItemId.getText();
        String itemName = textItemName.getText();
        double itemPrice = Double.parseDouble(textItemPrice.getText());
        int quantity = Integer.parseInt(textQuantity.getText());

        try {
            boolean isddPartsValidated = validateParts();
            if (isddPartsValidated) {
                boolean isUpdated = partsBO.updatePart(new AddPartsDto(itemId, itemName, itemPrice, quantity));
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item Is Updated!").show();
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
            addParts.getChildren().clear();
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/view_parts_table.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnStockOnAction(ActionEvent actionEvent) {
        try {
            addParts.getChildren().clear();
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/stock_table_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void comboBoxPartId(ActionEvent actionEvent) throws SQLException {
        String partId = txtPartId.getValue();

        AddPartsStockDto dto = addPartsModel.searchPartId(partId);

        textItemName.setText(dto.getPartName());
        textItemPrice.setText(dto.getPartPrice());
    }
}
