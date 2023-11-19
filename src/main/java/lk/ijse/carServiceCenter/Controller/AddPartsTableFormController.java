package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class AddPartsTableFormController {

    @FXML
    private AnchorPane AddPartsTable;

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colItemQuantity;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imagefrunt;

    @FXML
    private TableView<?> tblPartsTable;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            AddPartsTable.getChildren().clear();
            AddPartsTable.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/add_parts_form.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
