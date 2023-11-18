package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class BookingFormController {

    @FXML
    private JFXButton btnViewBookingTable;

    @FXML
    private AnchorPane BookingPage;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnViewCustomer;

    @FXML
    private JFXComboBox<?> comBoxNIC;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TextField textBookId;

    @FXML
    private TextField textBookType;

    @FXML
    private DatePicker textDate;

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            BookingPage.getChildren().clear();
            BookingPage.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    void btnViewBookingTableOnAction(ActionEvent event) {
        try {
            BookingPage.getChildren().clear();
            BookingPage.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/view_booking_table.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void cmbNICOnAction(ActionEvent event) {

    }
}
