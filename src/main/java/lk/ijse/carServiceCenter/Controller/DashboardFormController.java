package lk.ijse.carServiceCenter.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {

        @FXML
        private Button btnBook;

        @FXML
        private Button btnCustomerAdd;

        @FXML
        private Button btnHome;

        @FXML
        private Button btnLogOut;

        @FXML
        private ImageView btnPlus;

        @FXML
        private Button btnRepair;

        @FXML
        private ImageView btnRepairCars;

        @FXML
        private Button btnWallate;

        @FXML
        private ImageView btnWashingCars;

        @FXML
        private AnchorPane dashboard;

        @FXML
        private ImageView imageBack;

        @FXML
        private ImageView imagefrunt;

        @FXML
        void btnAddCustomerOnAction(ActionEvent event) {

        }

        @FXML
        void btnBookOnAction(ActionEvent event) {

        }

        @FXML
        void btnHomeOnAction(ActionEvent event) {

        }

        @FXML
        void btnLogOutOnAction(ActionEvent event) {

        }

        @FXML
        void btnPlusOnAction(MouseEvent event) throws IOException {
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/register_form.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) dashboard.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Register");
                stage.centerOnScreen();
        }

        @FXML
        void btnRepairCarsOnAction(MouseEvent event) {

        }

        @FXML
        void btnRepairOnAction(ActionEvent event) {

        }

        @FXML
        void btnWallateOnAction(ActionEvent event) {

        }

        @FXML
        void btnWashingCarsOnAction(MouseEvent event) {

        }

}
