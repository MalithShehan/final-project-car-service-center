package lk.ijse.carServiceCenter.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.dto.AddCustomerDto;
import lk.ijse.carServiceCenter.dto.tm.CustomerTm;
import lk.ijse.carServiceCenter.model.AddCustomerModel;
import org.kordamp.ikonli.javafx.FontIcon;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class AddCustomerFormController {

    @FXML
    private AnchorPane AddCustomer;

    @FXML
    private Button addBtn;

    @FXML
    private Button btnClear;

    @FXML
    private TableColumn<?, ?> colTellNumber;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

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
    private TableView<CustomerTm> tblCustormer;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textNIC;

    @FXML
    private TextField textName;

    @FXML
    private TextField textTelNumber;

    @FXML
    private TextField textEmail;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;



    public void initialize() {
        setCellValueFactory();
        loadAllCustomers();
    }

    private void setCellValueFactory() {
        colNIC.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTellNumber.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

        private void loadAllCustomers() {
            var model = new AddCustomerModel();

            ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

            try {
                List<AddCustomerDto> dtoList = model.getAllCustomers();

                for (AddCustomerDto dto : dtoList) {
                    obList.add(
                            new CustomerTm(
                                    dto.getCustomerNIC(),
                                    dto.getCustomerName(),
                                    dto.getAddress(),
                                    dto.getTel(),
                                    dto.getEmail()
                            )
                    );
                }
                tblCustormer.setItems(obList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @FXML
    void addBtnOnAction(ActionEvent event) {
         String name = textName.getText();
         String NIC = textNIC.getText();
         String address = textAddress.getText();
         String tell = textTelNumber.getText();
         String email = textEmail.getText();

         var model = new AddCustomerModel();

         try {
             boolean isSaved = model.saveTask(new AddCustomerDto(NIC, name, address, tell, email));
             if (isSaved) {
                 new Alert(Alert.AlertType.CONFIRMATION,"Customer Added Successfully").show();
                 return;
             }
         } catch (SQLException e) {
             new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
         }
    }

    @FXML
    void btnAddCustomerOnAction(MouseEvent event) {
        try {
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBookOnAction(MouseEvent event) {
        try {
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/booking_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        textAddress.setText("");
        textEmail.setText("");
        textName.setText("");
        textNIC.setText("");
        textTelNumber.setText("");
    }

    @FXML
    void btnDashboardOnAction(MouseEvent event) {
        try {
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnLogOutOnAction(MouseEvent event) {
        try {
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRepairOnAction(MouseEvent event) {
        try {
            AddCustomer.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repairCar_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnWallteOnAction(MouseEvent event) {

    }

    public void updateBtnOnAction(ActionEvent actionEvent) {
        String name = textName.getText();
        String NIC = textNIC.getText();
        String address = textAddress.getText();
        String tell = textTelNumber.getText();
        String email = textEmail.getText();

        var dto = new AddCustomerDto(name, NIC, address, tell, email);

        var model = new AddCustomerModel();

        try {
            boolean isUpdate = model.updateCustomer(dto);
            if (isUpdate) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated!").show();
                return;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String NIC = textNIC.getText();

        var customerModel = new AddCustomerModel();

        try {
            boolean isDelete = customerModel.deleteCustomer(NIC);

            if (isDelete) {
                tblCustormer.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void textSearchOnAction(ActionEvent actionEvent) {
        String nic = textNIC.getText();

        var model = new AddCustomerModel();

        try {
            AddCustomerDto dto = model.searchCustomer(nic);

            if (dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Customer Not Found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void fillFields(AddCustomerDto dto) {
        textName.setText(dto.getCustomerName());
        textNIC.setText(dto.getCustomerNIC());
        textAddress.setText(dto.getAddress());
        textTelNumber.setText(dto.getTel());
        textEmail.setText(dto.getEmail());
    }
}
