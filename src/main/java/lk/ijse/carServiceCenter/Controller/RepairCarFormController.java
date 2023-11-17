package lk.ijse.carServiceCenter.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.util.Objects;

public class RepairCarFormController {

    @FXML
    private Button addBtn;

    @FXML
    private Button addPartsBtn;

    @FXML
    private Button btnClear;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colRepairPrice;

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
    private AnchorPane repairCar;

    @FXML
    private TableView<?> tblCarRepair;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textNIC;

    @FXML
    private TextField textName;

    @FXML
    private TextField textRepairPrice;

    @FXML
    void addBtnOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddCustomerOnAction(MouseEvent event) {
        try {
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnAddPartsOnAction(ActionEvent event) {
        try {
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/addParts_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBookOnAction(MouseEvent event) {
        try {
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/booking_form.fxml"))));
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
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnLogOutOnAction(MouseEvent event) {
        try {
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRepairOnAction(MouseEvent event) {
        try {
            repairCar.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repairCar_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnWallteOnAction(MouseEvent event) {

    }

    @FXML
    void textAddressOnAction(ActionEvent event) {

    }

    @FXML
    void textNICOnAction(ActionEvent event) {

    }

    @FXML
    void textNameOnAction(ActionEvent event) {

    }

    @FXML
    void textRepairPriceOnAction(ActionEvent event) {

    }

}
