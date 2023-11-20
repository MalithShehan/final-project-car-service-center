package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.dto.BookingDto;
import lk.ijse.carServiceCenter.dto.tm.CustomerTm;
import lk.ijse.carServiceCenter.model.AddCustomerModel;
import lk.ijse.carServiceCenter.model.BookingModel;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class BookingFormController {

    private final AddCustomerModel customerModel = new AddCustomerModel();
    private final ObservableList<CustomerTm> obList = FXCollections.observableArrayList();
    private final BookingModel bookingModel = new BookingModel();
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
    private JFXComboBox<String> comBoxNIC;

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
    private TextField textName;

    @FXML
    private Label lblCustomerName;

    public void initialize() {
        loadCustomerNICs();
    }

    private void loadCustomerNICs() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<AddCustomerDto> cusList = customerModel.loadAllCustomers();

            for (AddCustomerDto dto : cusList) {
                obList.add(dto.getCustomerNIC());
            }
            comBoxNIC.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String bookId = textBookId.getText();
        String bookType = textBookType.getText();
        String customerNIC = comBoxNIC.getValue();

        if (customerNIC == null || customerNIC.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select a customer NIC").show();
            return;
        }

        Date date = Date.valueOf(textDate.getValue());

        var bookDto = new BookingDto(bookId, bookType, customerNIC, date);

        var model = new BookingModel();
        try {
            boolean isBookingValidated = validateBooking();
            if (isBookingValidated) {
                boolean isSaved = model.saveBooking(bookDto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Saved!").show();
                    clearFields();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private boolean validateBooking() {
        String bookId = textBookId.getText();

        boolean isBookIdValidated = Pattern.matches("B\\d{3}", bookId);
        if (!isBookIdValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Booking ID!").show();
            return false;
        }
        return true;
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
        clearFields();
    }

    private void clearFields() {
        textName.setText("");
        textBookId.setText("");
        textBookType.setText("");
        textDate.setValue(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String bookId = textBookId.getText();

        var bookingModel = new BookingModel();

        try {
            boolean isDeleted = bookingModel.deleteBooking(bookId);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Booking Deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String bookId = textBookId.getText();
        String bookType = textBookType.getText();
        String customerNIC = comBoxNIC.getValue();
        Date date = Date.valueOf(textDate.getValue());

        var dto = new BookingDto(bookId, bookType, customerNIC, date);

        var model = new BookingModel();

        try {
            boolean isUpdated = model.updateBooking(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Booking Is Updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
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
    void cmbNICOnAction(ActionEvent event) throws SQLException {
        String customerNIC = comBoxNIC.getValue();

        AddCustomerDto dto = customerModel.searchCustomer(customerNIC);

        textName.setText(dto.getCustomerName());
    }
}
