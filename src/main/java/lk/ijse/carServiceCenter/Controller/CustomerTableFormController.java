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

public class CustomerTableFormController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTellNumber;

    @FXML
    private AnchorPane customerTable;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            customerTable.getChildren().clear();
            customerTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_customer_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
