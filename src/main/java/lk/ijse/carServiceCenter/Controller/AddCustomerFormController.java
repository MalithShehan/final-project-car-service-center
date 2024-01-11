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
import lk.ijse.carServiceCenter.bo.BOFactory;
import lk.ijse.carServiceCenter.bo.custom.CustomerBO;
import lk.ijse.carServiceCenter.bo.custom.impl.CustomerBOImpl;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.model.AddCustomerModel;
import org.kordamp.ikonli.javafx.FontIcon;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

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

    private AddCustomerModel addCustomerModel = new AddCustomerModel();

    CustomerBOImpl customerBO = (CustomerBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

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
        Date date = Date.valueOf(txtDate.getValue());

        try {
            boolean isCustomerAddValidated = validateCustomer();
            if (isCustomerAddValidated) {
                boolean isSaved = customerBO.saveCustomer(new AddCustomerDto(custNIC, custName, address, telNumber, email, date));
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Added Successfully").show();
                    clearField();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateCustomer() {
        String custNIC = textNIC.getText();
        String custName = textName.getText();
        String address = textAddress.getText();
        String telNumber = textTelNumber.getText();
        String email = textEmail.getText();

        boolean isCustNICValidated = Pattern.matches("^\\d+$", custNIC);
        if (!isCustNICValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Customer NIC").show();
            return false;
        }

        boolean isCustomerNameValidated = Pattern.matches("^[A-Z][a-z]*$", custName);
        if (!isCustomerNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Customer Name").show();
            return false;
        }

        boolean isCustomerAddressValidated = Pattern.matches("^\\d{2}\\s[a-zA-Z0-9\\s]+$", address);
        if (!isCustomerAddressValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Customer Address").show();
            return false;
        }

        boolean isCustomerTelNumberValidated = Pattern.matches("^\\d+$", telNumber);
        if (!isCustomerTelNumberValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Tell Number").show();
            return false;
        }

        boolean isCustomerEmailValidated = Pattern.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$", email);
        if (!isCustomerEmailValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Email").show();
            return false;
        }
        return true;
    }

    private void clearField() {
        textNIC.setText("");
        textName.setText("");
        textAddress.setText("");
        textTelNumber.setText("");
        textEmail.setText("");
        txtDate.setValue(null);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearField();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String nic = textNIC.getText();

        var customerModel = new AddCustomerModel();

        try {
            boolean isDeleted = customerModel.deleteCustomer(nic);

            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String custNIC = textNIC.getText();
        String custName = textName.getText();
        String address = textAddress.getText();
        String telNumber = textTelNumber.getText();
        String email = textEmail.getText();
        Date date = Date.valueOf(txtDate.getValue());


        var dto = new AddCustomerDto(custNIC, custName, address, telNumber, email, date);

        try {
            boolean isValidatedCustomer = validateCustomer();
            if (isValidatedCustomer) {
                boolean isUpdated = customerBO.updateCustomer(dto);
                System.out.println(isUpdated);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated!").show();
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        String nic = textNIC.getText();

        try {
            AddCustomerDto dto = customerBO.searchCustomer(nic);

            if (dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Customer Not Fount!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void fillFields(AddCustomerDto dto) {
        textNIC.setText(dto.getCustomerNIC());
        textName.setText(dto.getCustomerName());
        textAddress.setText(dto.getAddress());
        textTelNumber.setText(dto.getTel());
        textEmail.setText(dto.getEmail());
        txtDate.setValue(LocalDate.parse(dto.getDate().toLocaleString()));
    }

}
