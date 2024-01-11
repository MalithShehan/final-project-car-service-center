package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.bo.BOFactory;
import lk.ijse.carServiceCenter.bo.custom.RepairBO;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.RegisterDto;
import lk.ijse.carServiceCenter.dto.RepairDto;
import lk.ijse.carServiceCenter.dto.tm.RepairTm;
import lk.ijse.carServiceCenter.model.AddPartsModel;
import lk.ijse.carServiceCenter.model.RepairModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
    private TableView<RepairTm> repairTableView;

    RepairBO repairBO = (RepairBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REPAIR);

    public void initialize() {
        setCellValueFactory();
        loadAllParts();
    }

    private void loadAllParts() {
        var model = new RepairModel();

        ObservableList<RepairTm> obList = FXCollections.observableArrayList();

        try {
            List<RepairDto> dtoList = repairBO.getAllRepair();

            for (RepairDto dto : dtoList) {
                obList.add(new RepairTm(
                        dto.getRepairId(),
                        dto.getRepairType(),
                        dto.getRepairPrice(),
                        dto.getCustomerNIC()
                        )
                );
            }
            repairTableView.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colRepairID.setCellValueFactory(new PropertyValueFactory<>("repairId"));
        colRepairType.setCellValueFactory(new PropertyValueFactory<>("repairType"));
        colRepairPrice.setCellValueFactory(new PropertyValueFactory<>("repairPrice"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));
    }

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
