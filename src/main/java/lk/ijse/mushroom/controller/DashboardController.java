package lk.ijse.mushroom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {

    public AnchorPane ancMainContainer;
    public Button btnCustomer;
    public Button btnOrder;
    public Button btnEmployee;
    public Button btnProduct;
    public Button btnFarmHouse;
    public Button btnDeliver;
    public Button btnFeedback;
    public Button btnMushroomBatch;
    public Button btnPay;
    public Button btnDashboard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // this method run with Dashboard.fxml ui load
        navigateTo("/view/DashboardPage.fxml");
    }

    public void btnGoCustomerPageOnAction(ActionEvent actionEvent) {
        navigateTo("/view/CustomerPage.fxml");
    }

    public void btnGoOrderPageOnAction(ActionEvent actionEvent) {
        navigateTo("/view/Order.fxml");
    }


    public void btnProductPageOnAction(ActionEvent actionEvent) {
        navigateTo("/view/product.fxml");
    }

    public void btnGoEmployeePageOnAction(ActionEvent actionEvent) {
        navigateTo("/view/Employee.fxml");
    }

    public void btnFarmHouseOnAction(ActionEvent actionEvent) {
        navigateTo("/view/FarmHouse.fxml");
    }

    public void btnDeliverOnAction(ActionEvent actionEvent) {
        navigateTo("/view/DeliverPage.fxml");
    }

    public void btnFeedbackOnAction(ActionEvent actionEvent) {
        navigateTo("/view/Feedback.fxml");
    }

    public void btnMushroomBatchOnAction(ActionEvent actionEvent) {
        navigateTo("/view/MushroomBatch.fxml");
    }

    private void navigateTo(String path) {
        try {
            ancMainContainer.getChildren().clear();

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));

            anchorPane.prefWidthProperty().bind(ancMainContainer.widthProperty());
            anchorPane.prefHeightProperty().bind(ancMainContainer.heightProperty());

            ancMainContainer.getChildren().add(anchorPane);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Page not found..!").show();
            e.printStackTrace();
        }
    }

    public void btnPayOnAction(ActionEvent actionEvent) { navigateTo("/view/Pay.fxml");

    }

    public void btnGoDashboardPagOnAction(ActionEvent actionEvent) {
        navigateTo("/view/DashboardPage.fxml");
    }
}