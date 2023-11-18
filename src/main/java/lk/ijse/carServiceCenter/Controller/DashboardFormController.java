package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardFormController {

        @FXML
        private JFXButton btnBookin;

        @FXML
        private JFXButton btnCustomer;

        @FXML
        private JFXButton btnHome;

        @FXML
        private ImageView btnPlus;

        @FXML
        private ImageView btnRepairCars;

        @FXML
        private ImageView btnWashingCars;

        @FXML
        private AnchorPane dashboard;

        @FXML
        private ImageView imageBack;

        @FXML
        private ImageView imagefrunt;

        @FXML
        void btnBookinOnAction(ActionEvent event) {
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/booking_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void btnCustomerOnAction(ActionEvent event)  {
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_customer_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void btnHomeOnAction(ActionEvent event) {
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void btnPlusOnAction(MouseEvent event) {
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/register_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void btnRepairCarsOnAction(MouseEvent event) {
        }

        @FXML
        void btnWashingCarsOnAction(MouseEvent event) {

        }

        @FXML
        void searchOnAction(ActionEvent event) {

        }

        public void btnRepairOnAction(ActionEvent actionEvent) {
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/repair_car_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        public void btnWallateOnAction(ActionEvent actionEvent) {
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/wallet_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        public void btnLogOutOnAction(ActionEvent actionEvent) {
        }
}
