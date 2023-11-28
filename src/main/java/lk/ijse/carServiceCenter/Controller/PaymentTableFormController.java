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
    private TableView<?> tblDetails;

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
