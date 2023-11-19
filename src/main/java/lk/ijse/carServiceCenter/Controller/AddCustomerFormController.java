package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.model.AddCustomerModel;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AddCustomerFormController {

    @FXML
    private AnchorPane AddCustomer;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnViewCustomer;

    @FXML
    private FontIcon dashBordBtn;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textNIC;

    @FXML
    private TextField textName;

    @FXML
    private TextField textTelNumber;

    @FXML
    private DatePicker txtDate;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            AddCustomer.getChildren().clear();
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String custNIC = textNIC.getText();
        String custName = textName.getText();
        String address = textAddress.getText();
        String telNumber = textTelNumber.getText();
        String email = textEmail.getText();

        var AddCustomerDto = new AddCustomerDto(custNIC, custName, address, telNumber, email);

        try {
            boolean isSaved = AddCustomerModel.saveCustomer(AddCustomerDto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Added Successfully").show();
                clearField();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void clearField() {
        textNIC.setText("");
        textName.setText("");
        textAddress.setText("");
        textTelNumber.setText("");
        textEmail.setText("");
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
    void btnViewCustomerOnAction(ActionEvent event) {
        try {
            AddCustomer.getChildren().clear();
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/view_customer_table_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void textSearchOnAction(ActionEvent event) {

    }

}
