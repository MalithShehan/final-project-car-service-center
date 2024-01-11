package lk.ijse.carServiceCenter.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.carServiceCenter.bo.BOFactory;
import lk.ijse.carServiceCenter.bo.custom.RegisterBO;
import lk.ijse.carServiceCenter.dto.RegisterDto;
import lk.ijse.carServiceCenter.model.RegisterModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegisterFormController {

    @FXML
    private Button btnBack;

    @FXML
    private AnchorPane RegisterPage;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private ImageView imageBack;

    @FXML
    private ImageView imageView;

    @FXML
    private Text textFieldFirstName;

    @FXML
    private TextField textFirstName;

    @FXML
    private TextField textLastName;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField textUsername;
    private RegisterModel registerModel = new RegisterModel();

    RegisterBO registerBO = (RegisterBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTER);

    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        String userName = textUsername.getText();
        String password = textPassword.getText();

        try {
            boolean isRegisterValidated = validateUser();
            if (isRegisterValidated) {
                boolean isSaved = registerBO.saveRegister(new RegisterDto(firstName, lastName, userName, password));

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Register Successfully").show();
                    return;
                }
            }
            
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean validateUser() {
        String  firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        String userName = textUsername.getText();
        String password = textPassword.getText();

        boolean isFirsNameValidated = Pattern.matches("[A-Za-z]{3,}", firstName);
        if (! isFirsNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid First Name!").show();
            return false;
        }

        boolean isLastNameValidated = Pattern.matches( "[A-Za-z]{3,}", lastName);
        if (!isLastNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Last Name!").show();
            return false;
        }

        boolean isUserNameValidated = Pattern.matches("^[a-zA-Z][a-zA-Z0-9]{2,15}$", userName);
        if (!isUserNameValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Username!").show();
            return false;
        }

        boolean isPasswordValidated = Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d\\S]{8,}$", password);
        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.ERROR, "Invalid Password").show();
            return false;
        }
        return true;
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) RegisterPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.centerOnScreen();
    }

}
