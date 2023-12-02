package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.dto.DetailsDto;
import lk.ijse.carServiceCenter.dto.tm.DetailsTm;
import lk.ijse.carServiceCenter.gmail.Gmailer;
import lk.ijse.carServiceCenter.model.ServiceDetailsModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class PaymentTableFormController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSendMail;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> selectBtn;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colItemDetails;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colRepairDetail;

    @FXML
    private TableColumn<?, ?> colRepairPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private AnchorPane paymentTable;

    @FXML
    private TableView<DetailsTm> tblDetails;

    public static String name;
    public static String id;
    public static String repairDetails;
    public static double repairPrice;
    public static String itemDetails;
    public static double itemPrice;
    public static double total;
    public void initialize() {
        setCellValueFactory();
        loadAllDetails();
        tblDetails.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tblDetails.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                DetailsTm tm = tblDetails.getSelectionModel().getSelectedItem();
                if (tm != null) {
                    name = tm.getCustomerName();
                    id = tm.getCustomerNIC();
                    repairDetails = tm.getRepairType();
                    repairPrice = tm.getRepairPrice();
                    itemDetails = tm.getPartName();
                    itemPrice = tm.getPartPrice();
                    total = tm.getTotal();
                }
            }
        });
    }

    private void loadAllDetails() {
        var model = new ServiceDetailsModel();

        ObservableList<DetailsTm> obList = FXCollections.observableArrayList();
        try {
            List<DetailsTm> dtoList = model.getAllDetails();
            for (DetailsTm dto : dtoList) {
                obList.add(new DetailsTm(
                        dto.getCustomerName(),
                        dto.getCustomerNIC(),
                        dto.getRepairType(),
                        dto.getRepairPrice(),
                        dto.getPartName(),
                        dto.getPartPrice(),
                        (dto.getPartPrice() + dto.getRepairPrice()),
                        new Button()
                ));
            }
            tblDetails.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellValueFactory() {
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerNIC"));
        colRepairDetail.setCellValueFactory(new PropertyValueFactory<>("repairType"));
        colRepairPrice.setCellValueFactory(new PropertyValueFactory<>("repairPrice"));
        colItemDetails.setCellValueFactory(new PropertyValueFactory<>("partName"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        selectBtn.setCellValueFactory(new PropertyValueFactory<>("button"));
    }
    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            paymentTable.getChildren().clear();
            paymentTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/wallet_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSendMailOnAction(ActionEvent event) {
        if (id != null) {
            try {
                Gmailer.setEmailCom("shehansandakalum2003@gmail.com",name + "\n  " + id);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
