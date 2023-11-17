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

public class AddPartsFromController {

    @FXML
    private Button addBtn;

    @FXML
    private AnchorPane addParts;

    @FXML
    private Button btnClear;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

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
    private TableView<?> tblCarRepair;

    @FXML
    private TextField textItemId;

    @FXML
    private TextField textItemName;

    @FXML
    private TextField textItemPrice;

    @FXML
    private TextField textQuantity;

    @FXML
    void addBtnOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddCustomerOnAction(MouseEvent event) {
        try {
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBookOnAction(MouseEvent event) {
        try {
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/booking_form.fxml"))));
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
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_customer_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnLogOutOnAction(MouseEvent event) {
        try {
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnRepairOnAction(MouseEvent event) {
        try {
            addParts.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repairCar_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnWallteOnAction(MouseEvent event) {

    }

    @FXML
    void textItemIdOnAction(ActionEvent event) {

    }

    @FXML
    void textItemNameOnAction(ActionEvent event) {

    }

    @FXML
    void textItemPriceOnAction(ActionEvent event) {

    }

    @FXML
    void textQuantityOnAction(ActionEvent event) {

    }

}
