package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UserLoginController {

    @FXML
    private JFXButton btnSingIn;

    @FXML
    private ImageView imageBack;

    @FXML
    private AnchorPane loginPage;

    @FXML
    private Text textCreateAccount;

    @FXML
    private Text textForgetPassword;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField textUsername;

    @FXML
    void btnSingInOnAction(ActionEvent event) {
        try {
            loginPage.getChildren().clear();
            loginPage.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboard_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void createAccountOnAction(MouseEvent event) {
        try {
            loginPage.getChildren().clear();
            loginPage.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/register_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void forgetPasswordOnAction(MouseEvent event) {

    }

}
