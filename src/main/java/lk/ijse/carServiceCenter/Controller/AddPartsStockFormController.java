package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.bo.BOFactory;
import lk.ijse.carServiceCenter.bo.custom.PartsStockBO;
import lk.ijse.carServiceCenter.bo.custom.impl.PartsStockBOImpl;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.model.AddPartsModel;
import lk.ijse.carServiceCenter.model.AddPartsStockModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.regex.Pattern;

public class AddPartsStockFormController {

    @FXML
    public TextField textPartName;

    @FXML
    public TextField textPartPrice;

    @FXML
    public TextField textQtyOnHand;
    @FXML
    public TextField textItemId;

    @FXML
    private AnchorPane addPartsStock;

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
    private JFXButton btnBack;

    private AddPartsStockModel addPartsStockModel = new AddPartsStockModel();

    PartsStockBO partsStockBO = (PartsStockBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PARTS_STOCK);

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            addPartsStock.getChildren().clear();
            addPartsStock.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/stock_table_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String itemId = textItemId.getText();
        String partName = textPartName.getText();
        String partPrice = textPartPrice.getText();
        int qtyOnHand = Integer.parseInt(textQtyOnHand.getText());



        try {
            boolean isAddPartsStockValidated = validateParts();
            if (isAddPartsStockValidated) {
                boolean isSaved = partsStockBO.savePartsStock(new AddPartsStockDto(itemId, partName, partPrice, qtyOnHand ));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Parts Saved Successfully!").show();
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
        String itemId = textItemId.getText();

        boolean isPartsIdValidated = Pattern.matches("I\\d{3}", itemId);
        if (!isPartsIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Parts ID!").show();
            return false;
        }
        return true;
    }

    private void clarField() {
        textItemId.setText("");
        textPartName.setText("");
        textPartPrice.setText("");
        textQtyOnHand.setText("");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clarField();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String itemId = textItemId.getText();

        partsStockBO.deletePartsStock(itemId);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String partName = textPartName.getText();
        String partPrice = textPartPrice.getText();
        int qtyOnHand = Integer.parseInt(textQtyOnHand.getText());
        String itemId = textItemId.getText();

        try {
            boolean isddPartsStockValidated = validateParts();
            if (isddPartsStockValidated) {
                boolean isUpdated = partsStockBO.updatePartsStock(new AddPartsStockDto( itemId, partName, partPrice, qtyOnHand));
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
    void btnViewItemStockTableOnAction(ActionEvent event) {
       try {
            addPartsStock.getChildren().clear();
            addPartsStock.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/stock_table_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
