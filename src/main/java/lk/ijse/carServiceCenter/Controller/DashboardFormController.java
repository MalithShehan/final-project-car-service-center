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
import lk.ijse.carServiceCenter.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;

public class DashboardFormController {

        @FXML
        private JFXButton btnCarServices;

        @FXML
        private JFXButton btnCustomers;

        @FXML
        private ImageView btnMap;

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
        void btnCarServicesOnAction(ActionEvent event) throws JRException, SQLException {
                InputStream resourceAsStream = getClass().getResourceAsStream("/report/service_report.jrxml                     ");
                JasperDesign load = JRXmlLoader.load(resourceAsStream);
                JRDesignQuery jrDesignQuery = new JRDesignQuery();
                jrDesignQuery.setText("SELECT * FROM repaircar");
                load.setQuery(jrDesignQuery);

                JasperReport jasperReport = JasperCompileManager.compileReport(load);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DbConnection.getInstance().getConnection());
                JasperViewer.viewReport(jasperPrint, false);


        }

        @FXML
        void btnCustomersOnAction(ActionEvent event) throws JRException, SQLException {

                InputStream resourceAsStream = getClass().getResourceAsStream("/report/customer_report.jrxml");
                JasperDesign load = JRXmlLoader.load(resourceAsStream);
                JRDesignQuery jrDesignQuery = new JRDesignQuery();
                jrDesignQuery.setText("SELECT * FROM customer");
                load.setQuery(jrDesignQuery);

                JasperReport jasperReport = JasperCompileManager.compileReport(load);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DbConnection.getInstance().getConnection());
                JasperViewer.viewReport(jasperPrint, false);

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
                try {
                        dashboard.getChildren().clear();
                        dashboard.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml"))));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        public void btnMapOnAction(MouseEvent mouseEvent) {
        }
}
