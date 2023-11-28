package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;;import java.io.IOException;
import java.util.Objects;

public class WalletFormController {

    @FXML
    private JFXButton btnDetails;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private AnchorPane wallate;
    public void btnDetailsOnAction(ActionEvent actionEvent) {
        try {
            wallate.getChildren().clear();
            wallate.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/service_details_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnPaymentOnAction(ActionEvent actionEvent) {
        try {
            wallate.getChildren().clear();
            wallate.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/payment_table.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        try {
            wallate.getChildren().clear();
            wallate.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
