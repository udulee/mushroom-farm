package lk.ijse.mushroom.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class loginPageController {
    @FXML
    private AnchorPane loginAnchPane;

    @FXML
    private AnchorPane loginContentAnchPane;

    @FXML
    private Label loginHeaderLbl;

    @FXML
    private ImageView loginImg;

    @FXML
    private Label passwordLbl;

    @FXML
    private TextField passwordTxt;

    @FXML
    private ComboBox<String> roleCombo;

    @FXML
    private Label roleLbl;

    @FXML
    private Button signInBtn;

    @FXML
    private Label userIdLbl;

    @FXML
    private TextField userTxt;

    @FXML
    void roleComboActionClicked(ActionEvent event) {

    }

    @FXML
    void signInBtnOnAction(ActionEvent event) {
        String userName = userTxt.getText();
        String password = passwordTxt.getText();

        String real_user_name = "udulee";
        String real_password = "1234";

        if (userName.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION,"User Name and Password are Empty",ButtonType.OK).show();
            return;
        }

        if (userName.equals(real_user_name) && password.equals(real_password)) {
            new Alert(Alert.AlertType.INFORMATION,"Login Successful",ButtonType.OK).show();
            navigateTo("/view/DashBord.fxml");
            return;
        }
        new Alert(Alert.AlertType.INFORMATION,"Login Failed",ButtonType.OK).show();
        System.out.println("Sign in button pressed");
    }

    private void navigateTo(String path) {
        try {
            loginAnchPane.getChildren().clear();

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));

            anchorPane.prefWidthProperty().bind(loginAnchPane.widthProperty());
            anchorPane.prefHeightProperty().bind(loginAnchPane.heightProperty());
            loginAnchPane.getChildren().add(anchorPane);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Page not found..!").show();
            e.printStackTrace();
        }
    }
}
