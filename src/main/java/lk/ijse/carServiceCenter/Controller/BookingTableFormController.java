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

public class BookingTableFormController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colBookType;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private AnchorPane bookingTable;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            bookingTable.getChildren().clear();
            bookingTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/booking_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
