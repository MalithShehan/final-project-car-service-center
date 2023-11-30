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
import lk.ijse.carServiceCenter.dto.DetailsDto;
import lk.ijse.carServiceCenter.dto.tm.DetailsTm;
import lk.ijse.carServiceCenter.model.ServiceDetailsModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class PaymentTableFormController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSendMail;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colItemDetails;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colRepairDetail;

    @FXML
    private TableColumn<?, ?> colRepairPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private AnchorPane paymentTable;

    @FXML
    private TableView<DetailsTm> tblDetails;


    public void initialize() {
        setCellValueFactory();
        loadAllDetails();
    }
    private void loadAllDetails() {
        var model = new ServiceDetailsModel();

        ObservableList<DetailsTm> obList = FXCollections.observableArrayList();
        try {
            List<DetailsDto> dtoList = model.getAllDetails();

            for (DetailsDto dto : dtoList) {
                obList.add(new DetailsTm(
                        dto.getCustomerName(),
                        dto.getCustomerNIC(),
                        dto.getRepairType(),
                        dto.getRepairPrice(),
                        dto.getPartName(),
                        dto.getPartPrice()
                ));
            }
            tblDetails.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));
        colRepairDetail.setCellValueFactory(new PropertyValueFactory<>("repairType"));
        colRepairPrice.setCellValueFactory(new PropertyValueFactory<>("repairPrice"));
        colItemDetails.setCellValueFactory(new PropertyValueFactory<>("partName"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            paymentTable.getChildren().clear();
            paymentTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/wallet_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSendMailOnAction(ActionEvent event) {

    }

}
