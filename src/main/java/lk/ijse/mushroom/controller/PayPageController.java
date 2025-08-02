//package lk.ijse.mushroom.controller;
//
////import importjavafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import lk.ijse.mushroom.dto.CustomerDTO;
//import lk.ijse.mushroom.dto.PayDTO;
//import lk.ijse.mushroom.dto.tm.CustomerTM;
//import lk.ijse.mushroom.dto.tm.PayTM;
//import lk.ijse.mushroom.model.PayModel;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class PayPageController {
//
//    public TextField txtPaymentId;
//    public TextField txtOrderId;
//    public TextField txtPaymentMethod;
//    public TextField txtPaymentDate;
//    public TextField txtAmount;
//    public TableView tblPay;
//
//    private final String textPattern = "^[A-Z a-z ]+$";
//    private final String datePattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
//    //private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//    private final String amountPattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
//    public TableColumn tabPaymentId;
//    public TableColumn tabOrderId;
//    public TableColumn tabPaymentMethod;
//    public TableColumn tabPaymentDate;
//    public TableColumn tabAmount;
//    public Button btnAdd;
//    public Button btnUpdate;
//    public Button btnDelete;
//    public Button btnReset;
//
//
//    public void initialize(URL location, ResourceBundle resources) {
//        // table column and tm class properties link
//        initializeTable();
//        try {
//            resetPage();
//        } catch (Exception e) {
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
//        }
//    }
//    public void initializeTable() {
//        tabPaymentId.setCellValueFactory(new PropertyValueFactory<>("Payment_id"));
//        tabOrderId.setCellValueFactory(new PropertyValueFactory<>("order_id"));
//        tabPaymentMethod.setCellValueFactory(new PropertyValueFactory<>("payment_Method"));
//        tabPaymentDate.setCellValueFactory(new PropertyValueFactory<>("payment_date"));
//        tabAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
//    }
//
//    private void loadTableData() throws SQLException {
//
//        tblPay.setItems(FXCollections.observableArrayList(
//                PayModel.GetAll().stream()
//                        .map(PayDTO -> new PayDTO(
//                                PayDTO.getPaymentId(),
//                                PayDTO.getOrderId(),
//                                PayDTO.getPaymentMethod(),
//                                PayDTO.getPaymentDate(),
//                                PayDTO.getAmount()
//                        )).toList()
//        ));
//    }
//    private void resetPage() {
//        try {
//            loadTableData();
//            loadNextId();
//           // btnSave.setDisable(false);
//
//            btnDelete.setDisable(true);
//            btnUpdate.setDisable(true);
//
//            txtOrderId.setText("");
//            txtPaymentMethod.setText("");
//            txtPaymentDate.setText("");
//            txtAmount.setText("");
//        } catch (Exception e) {
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
//        }
//    }
//
//
//    public void btnAddButtonOnAction(ActionEvent actionEvent) {
//        String PaymentId = txtPaymentId.getText();
//        String OrderId = txtOrderId.getText();
//        String PaymentMethod = txtPaymentMethod.getText();
//        String PaymentDate = txtPaymentDate.getText();
//        String Amount = txtAmount.getText();
//
//
//            try {
//                PayDTO Pay = new PayDTO(
//                        Integer.parseInt(PaymentId),
//                        Integer.parseInt(OrderId),
//                        PaymentMethod,
//                        PaymentDate,
//                        Amount
//                );
//                boolean isAdd = PayModel.Add(Pay);
//
//                if (isAdd) {
//                    resetPage();
//                    new Alert(Alert.AlertType.INFORMATION, "pay add successfully.").show();
//                } else {
//                    new Alert(Alert.AlertType.ERROR, "Fail to add pay.").show();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                new Alert(Alert.AlertType.ERROR, "Fail to add pay.").show();
//            }
//        }
//    }
//
//    public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
//        String paymentId = txtPaymentId.getText();
//        String orderId = txtOrderId.getText();
//        String paymentMethod = txtPaymentMethod.getText();
//        String paymentDate = txtPaymentDate.getText();
//        String amount = txtAmount.getText();
//
//        try {
//            PayDTO pay = new PayDTO(
//                    Integer.parseInt(paymentId),
//                    Integer.parseInt(orderId),
//                    paymentMethod,
//                    paymentDate,
//                    amount
//            );
//            boolean isUpdate = PayModel.Update(pay);
//
//            if (isUpdate) {
//                resetPage();
//                new Alert(Alert.AlertType.INFORMATION, "Pay saved successfully.").show();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Fail to save pay.").show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, "Fail to save pay.").show();
//        }
//    }
//    private void loadNextId() {
//        try {
//            int nextId = PayModel.getNextId();
//            txtPaymentId.setText(String.valueOf(nextId));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {
//    }
//
//    public void tblpayOnMouseClicked(MouseEvent mouseEvent) {
//        PayTM selectedItem = (PayTM) tblPay.getSelectionModel().getSelectedItem();
//
//
//        if (selectedItem != null){
//            txtPaymentId.setText(String.valueOf(selectedItem.getPaymentId()));
//            txtOrderId.setText(String.valueOf(selectedItem.getOrderId()));
//            txtPaymentMethod.setText(selectedItem.getPaymentMethod());
//            txtPaymentDate.setText(selectedItem.getPaymentDate());
//            txtAmount.setText(String.valueOf(selectedItem.getAmount()));
//
//            btnAdd.setDisable(true);
//            btnDelete.setDisable(false);
//            btnUpdate.setDisable(false);
//            btnReset.setDisable(false);
//
//
//        }
//    }
//
//    public void btnResetButtonOnAction(ActionEvent actionEvent) {
//
//    }
//}
//
//public void main() {
//}

package lk.ijse.mushroom.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.PayDTO;
import lk.ijse.mushroom.dto.tm.PayTM;
import lk.ijse.mushroom.model.PayModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PayPageController implements Initializable {

    public TextField txtPaymentId;
    public TextField txtOrderId;
    public TextField txtPaymentMethod;
    public TextField txtPaymentDate;
    public TextField txtAmount;
    public TableView<PayTM> tblPay;
    public TableColumn<PayTM, Integer> tabPaymentId;
    public TableColumn<PayTM, Integer> tabOrderId;
    public TableColumn<PayTM, String> tabPaymentMethod;
    public TableColumn<PayTM, String> tabPaymentDate;
    public TableColumn<PayTM, String> tabAmount;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnReset;

    PayModel payModel = new PayModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTable();
        resetPage();
    }

    private void initializeTable() {
        tabPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        tabOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tabPaymentMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        tabPaymentDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        tabAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }

    private void loadTableData() throws SQLException {
        tblPay.setItems(FXCollections.observableArrayList(
                PayModel.GetAll().stream()
                        .map(dto -> new PayTM(
                                dto.getPaymentId(),
                                dto.getOrderId(),
                                dto.getPaymentMethod(),
                                dto.getPaymentDate(),
                                dto.getAmount()
                        )).toList()
        ));
    }

    private void resetPage() {
        try {
            loadTableData();
            loadNextId();
            txtOrderId.clear();
            txtPaymentMethod.clear();
            txtPaymentDate.clear();
            txtAmount.clear();
            btnAdd.setDisable(false);
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
            btnReset.setDisable(false);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
        }
    }

    private void loadNextId() {
        try {
            int nextId = PayModel.getNextId();
            txtPaymentId.setText(String.valueOf(nextId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAddButtonOnAction(ActionEvent actionEvent) {
        try {
            PayDTO pay = new PayDTO(
                    Integer.parseInt(txtPaymentId.getText()),
                    Integer.parseInt(txtOrderId.getText()),
                    txtPaymentMethod.getText(),
                    txtPaymentDate.getText(),
                    txtAmount.getText()
            );
            boolean isAdded = payModel.Add(pay);
            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Payment added successfully.").show();
                resetPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to add payment.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while adding payment.").show();
        }
    }

    public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
        try {
            PayDTO pay = new PayDTO(
                    Integer.parseInt(txtPaymentId.getText()),
                    Integer.parseInt(txtOrderId.getText()),
                    txtPaymentMethod.getText(),
                    txtPaymentDate.getText(),
                    txtAmount.getText()
            );
            boolean isUpdated = PayModel.Update(pay);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Payment updated successfully.").show();
                resetPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update payment.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while updating payment.").show();
        }
    }

    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {
        try {
            int paymentId = Integer.parseInt(txtPaymentId.getText());
            PayDTO pay = new PayDTO(paymentId, 0, null, null, null);
            boolean isDeleted = payModel.Delete(pay);
            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Payment deleted successfully.").show();
                resetPage();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to delete payment.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while deleting payment.").show();
        }
    }

    public void tblpayOnMouseClicked(MouseEvent mouseEvent) {
        PayTM selectedItem = tblPay.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            txtPaymentId.setText(String.valueOf(selectedItem.getPaymentId()));
            txtOrderId.setText(String.valueOf(selectedItem.getOrderId()));
            txtPaymentMethod.setText(selectedItem.getPaymentMethod());
            txtPaymentDate.setText(selectedItem.getPaymentDate());
            txtAmount.setText(selectedItem.getAmount());

            btnAdd.setDisable(true);
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
        }
    }

    public void btnResetButtonOnAction(ActionEvent actionEvent) {
        resetPage();
    }
}
