package lk.ijse.mushroom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    }
}
