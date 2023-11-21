package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.carServiceCenter.dto.AddPartsDto;
import lk.ijse.carServiceCenter.dto.tm.AddPartsTm;
import lk.ijse.carServiceCenter.model.AddPartsModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
    private TableView<AddPartsTm> tblPartsTable;

    private final AddPartsModel addPartsModel = new AddPartsModel();
    public void initialize() {
        setCellValueFactory();
        loadAllItems();
    }

    private void loadAllItems() {
        var model = new AddPartsModel();

        ObservableList<AddPartsTm> obList = FXCollections.observableArrayList();
        try {
            List<AddPartsDto> dtoList = model.loadAllItems();

            for (AddPartsDto dto : dtoList) {
                obList.add(new AddPartsTm(
                        dto.getItemId(),
                        dto.getItemName(),
                        dto.getItemPrice(),
                        dto.getQuantity()
                        )
                );
            }
            tblPartsTable.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        colItemQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

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
