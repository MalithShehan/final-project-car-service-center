package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ServiceDetailsFormController {
    @FXML
    public AnchorPane serviceDetails;
    @FXML
    public TableView tblDetails;
    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colBookType;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }
}
