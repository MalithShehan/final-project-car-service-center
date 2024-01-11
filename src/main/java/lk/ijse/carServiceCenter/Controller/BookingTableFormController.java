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
import lk.ijse.carServiceCenter.bo.custom.BookingBO;
import lk.ijse.carServiceCenter.dto.BookingDto;
import lk.ijse.carServiceCenter.dto.tm.BookingTm;
import lk.ijse.carServiceCenter.model.BookingModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
    private TableView<BookingTm> tblCustomer;

    BookingBO bookingBO = (BookingBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOKING);

    public void initialize() {
        setCellValueFactory();
        loadAllBookings();
    }

    private void loadAllBookings() {
        var model = new BookingModel();

        ObservableList<BookingTm> obList = FXCollections.observableArrayList();

        try {
            List<BookingDto> dtoList = bookingBO.getAllBokkings();

            for (BookingDto dto : dtoList) {
                obList.add(new BookingTm(
                        dto.getBookId(),
                        dto.getBookType(),
                        dto.getCustomerNIC(),
                        dto.getDate()
                ));
            }
            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("bookType"));
        colBookType.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

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
