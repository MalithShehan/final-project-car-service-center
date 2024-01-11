package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.bo.BOFactory;
import lk.ijse.carServiceCenter.bo.custom.PartsStockBO;
import lk.ijse.carServiceCenter.dto.AddPartsStockDto;
import lk.ijse.carServiceCenter.dto.tm.AddPartsStockTm;
import lk.ijse.carServiceCenter.model.AddPartsStockModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class StockTableFormController {

    @FXML
    private AnchorPane AddPartsStockTable;

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colIPartName;

    @FXML
    private TableColumn<?, ?> colIPartPrice;

    @FXML
    private TableColumn<?, ?> colIPartQuantity;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TableView<AddPartsStockTm> tblPartsStockTable;

    PartsStockBO partsStockBO = (PartsStockBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PARTS_STOCK);

    public void initialize() {
        setCellValueFactory();
        loadAllParts();
    }

    private void loadAllParts() {
        var model = new AddPartsStockModel();

        ObservableList<AddPartsStockTm> obList = FXCollections.observableArrayList();
        try {
            List<AddPartsStockDto> dtoList = partsStockBO.getAllPartsStock();
            for (AddPartsStockDto dto : dtoList) {
                obList.add(new AddPartsStockTm(
                        dto.getItemId(),
                        dto.getPartName(),
                        dto.getPartPrice(),
                        dto.getQtyOnHand()
                ));
                }
            tblPartsStockTable.setItems(obList);
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colIPartName.setCellValueFactory(new PropertyValueFactory<>("partName"));
        colIPartPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        colIPartQuantity.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            AddPartsStockTable.getChildren().clear();
            AddPartsStockTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_parts_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnAddStockOnAction(ActionEvent actionEvent) {
        try {
            AddPartsStockTable.getChildren().clear();
            AddPartsStockTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_partsStock_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
