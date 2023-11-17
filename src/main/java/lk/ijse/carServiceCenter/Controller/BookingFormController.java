package lk.ijse.carServiceCenter.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.dto.BookingDto;
import lk.ijse.carServiceCenter.model.BookingModel;
import org.kordamp.ikonli.javafx.FontIcon;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

public class BookingFormController {

    @FXML
    private AnchorPane Booking;

    @FXML
    private Button addBtn;

    @FXML
    private Button btnClear;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookType;

    @FXML
    private TableColumn<?, ?> colCustomerNIC;

    @FXML
    private FontIcon dashBordBtn;

    @FXML
    private ImageView imageAddCustomer;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageBar;

    @FXML
    private ImageView imageBooking;

    @FXML
    private ImageView imageDashboard;

    @FXML
    private ImageView imageLogOut;

    @FXML
    private ImageView imageRepair;

    @FXML
    private ImageView imageWallate;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TableView<?> tblCustormer;

    @FXML
    private TextField textBookId;

    @FXML
    private TextField textBookType;

    @FXML
    private DatePicker textDate;

    @FXML
    private Button btnUpdate;

    @FXML
    private Text textNIC;
    @FXML
    void addBtnOnAction(ActionEvent event) {
        String bookId = textBookId.getText();
        String bookType = textBookType.getText();
        String customerNIC = textNIC.getText();
        Date date = Date.valueOf(textDate.getValue());

        var model = new BookingModel();

        try {
            boolean isSaved = model.saveBooking(new BookingDto(bookId, bookType, customerNIC, date));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Booking Add Successfully").show();
                return;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnAddCustomerOnAction(MouseEvent event) {
        try {
            Booking.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBookOnAction(MouseEvent event) {
        try {
            Booking.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/booking_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(MouseEvent event) {
        try {
            Booking.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnLogOutOnAction(MouseEvent event) {
        try {
            Booking.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRepairOnAction(MouseEvent event) {
        try {
            Booking.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repairCar_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnWallteOnAction(MouseEvent event) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String bookId = textBookId.getText();
        String bookType = textBookType.getText();
        String customerNIC = textNIC.getText();
        Date date = Date.valueOf(textDate.getValue());

        try {
            boolean isUpdate = BookingModel.updateBooking(new BookingDto(bookId, bookType, customerNIC, date));
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Booking Updated").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void cmbNICOnAction(ActionEvent actionEvent) {
    }
}
