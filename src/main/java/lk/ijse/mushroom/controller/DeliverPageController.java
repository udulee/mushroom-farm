//package lk.ijse.mushroom.controller;
//
//import com.sun.java.accessibility.util.EventID;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import lk.ijse.mushroom.dto.EmployeeDTO;
//import lk.ijse.mushroom.dto.tm.CustomerTM;
//import lk.ijse.mushroom.dto.tm.DeliverPageTM;
//import lk.ijse.mushroom.model.DeliverPageModel;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class DeliverPageController implements Initializable {
//
//    public TextField txtDeliverId;
//    public TextField txtOrderId;
//    public TextField txtCustomerId;
//    public TextField txtOrderAmount;
//    public Button btnAdd;
//    public Button btnUpdate;
//    public Button btnDelete;
//    public TableView<DeliverPageTM> tblDeliver;
//    public TableColumn<DeliverPageTM , Integer> tabDeliverId;
//    public TableColumn<DeliverPageTM , Integer> tabOrderId;
//    public TableColumn<DeliverPageTM , Integer> tabCustomerId;
//    public TableColumn<DeliverPageTM , String> tabOrderAmount;
//
//    DeliverPageModel deliverPageModel = new DeliverPageModel();
//
//    public void btnAddButtonOnAction(ActionEvent actionEvent) {
//        String DeliverId = txtDeliverId.getText();
//        String OrderId = txtOrderId.getText();
//        String CustomerId = txtCustomerId.getText();
//        String email = txtEmail.getText();
//        String contact = txtContact.getText();
//        String salary = txtSalary.getText();
//
//        try {
//            EmployeeDTO employee = new EmployeeDTO(
//                    Integer.parseInt(EmployeeId),
//                    FristName,
//                    lastName,
//                    Double.parseDouble(email),
//                    contact,
//                    salary
//            );
//            boolean isAdd = employeeModel.add(employee);
//
//            if (isAdd) {
//                resetPage();
//                new Alert(Alert.AlertType.INFORMATION, "Employee add successfully.").show();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Fail to add .").show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            new Alert(Alert.AlertType.ERROR, "Fail to save Add.").show();
//        }
//    }
//    private void loadNextId() {
//        try {
//            int nextId = employeeModel.getNextId();
//            txtEmployeeId.setText(String.valueOf(nextId));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    }
//
//    public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
//    }
//
//    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {
//    }
//
//    public void tblDeliverOnMouseClicked(MouseEvent mouseEvent) {
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        initializeTable();
//        reload();
//    }
//
//    public void initializeTable() {
//        tabDeliverId.setCellValueFactory(new PropertyValueFactory<>("deliverId"));
//        tabOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
//        tabCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
//        tabOrderAmount.setCellValueFactory(new PropertyValueFactory<>("OrderAmount"));
//    }
//
//    private void loadTableData() throws SQLException {
//
//        tblDeliver.setItems(FXCollections.observableArrayList(
//                deliverPageModel.GetAllDeliverPage().stream()
//                        .map(deliverPageDTO -> new DeliverPageTM(
//                                deliverPageDTO.getDeliverId(),
//                                deliverPageDTO.getOrderId(),
//                                deliverPageDTO.getCustomerId(),
//                                deliverPageDTO.getOrderAmount()
//                        )).toList()
//        ));
//    }
//
//
//    public void reload(){
//        try{
//            loadTableData();
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR,e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}

package lk.ijse.mushroom.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.DeliverPageDTO;
import lk.ijse.mushroom.dto.tm.DeliverPageTM;
import lk.ijse.mushroom.model.DeliverPageModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeliverPageController implements Initializable {

    public TextField txtDeliverId;
    public TextField txtOrderId;
    public TextField txtCustomerId;
    public TextField txtOrderAmount;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView<DeliverPageTM> tblDeliver;
    public TableColumn<DeliverPageTM, Integer> tabDeliverId;
    public TableColumn<DeliverPageTM, Integer> tabOrderId;
    public TableColumn<DeliverPageTM, Integer> tabCustomerId;
    public TableColumn<DeliverPageTM, String> tabOrderAmount;

    DeliverPageModel deliverPageModel = new DeliverPageModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTable();
        loadNextId();
        reload();
    }

    public void initializeTable() {
        tabDeliverId.setCellValueFactory(new PropertyValueFactory<>("deliverId"));
        tabOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        tabCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tabOrderAmount.setCellValueFactory(new PropertyValueFactory<>("orderAmount"));
    }

    private void loadTableData() throws SQLException {
        tblDeliver.setItems(FXCollections.observableArrayList(
                deliverPageModel.getAll().stream()
                        .map(dto -> new DeliverPageTM(
                                dto.getDeliverId(),
                                dto.getOrderId(),
                                dto.getCustomerId(),
                                dto.getOrderAmount()
                        )).toList()
        ));
    }

    public void reload() {
        try {
            loadTableData();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading data: " + e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void loadNextId() {
        try {
            int nextId = deliverPageModel.getNextId();
            txtDeliverId.setText(String.valueOf(nextId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnAddButtonOnAction(ActionEvent actionEvent) {
        try {
            DeliverPageDTO dto = new DeliverPageDTO(
                    Integer.parseInt(txtDeliverId.getText()),
                    Integer.parseInt(txtOrderId.getText()),
                    Integer.parseInt(txtCustomerId.getText()),
                    txtOrderAmount.getText()
            );

            boolean isAdded = deliverPageModel.add(dto);
            if (isAdded) {
                new Alert(Alert.AlertType.INFORMATION, "Added successfully!").show();
                reload();
                clearFields();
                loadNextId();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to add!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
        try {
            DeliverPageDTO dto = new DeliverPageDTO(
                    Integer.parseInt(txtDeliverId.getText()),
                    Integer.parseInt(txtOrderId.getText()),
                    Integer.parseInt(txtCustomerId.getText()),
                    txtOrderAmount.getText()
            );

            boolean isUpdated = deliverPageModel.update(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Updated successfully!").show();
                reload();
                clearFields();
                loadNextId();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {
        try {
            int deliverId = Integer.parseInt(txtDeliverId.getText());
            boolean isDeleted = deliverPageModel.delete(deliverId);

            if (isDeleted) {
                new Alert(Alert.AlertType.INFORMATION, "Deleted successfully!").show();
                reload();
                clearFields();
                loadNextId();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to delete!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).show();
        }
    }

    public void tblDeliverOnMouseClicked(MouseEvent event) {
        DeliverPageTM selected = tblDeliver.getSelectionModel().getSelectedItem();
        if (selected != null) {
            txtDeliverId.setText(String.valueOf(selected.getDeliverId()));
            txtOrderId.setText(String.valueOf(selected.getOrderId()));
            txtCustomerId.setText(String.valueOf(selected.getCustomerId()));
            txtOrderAmount.setText(selected.getOrderAmount());
        }
    }

    private void clearFields() {
        txtDeliverId.clear();
        txtOrderId.clear();
        txtCustomerId.clear();
        txtOrderAmount.clear();
    }
}
