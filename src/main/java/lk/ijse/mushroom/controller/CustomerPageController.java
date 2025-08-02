package lk.ijse.mushroom.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.CustomerDTO;
import lk.ijse.mushroom.dto.tm.CustomerTM;
import lk.ijse.mushroom.model.CustomerModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerPageController implements Initializable {
    public Label lblCustomerId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtPhone;

    // Create a CustomerModel object to access database-related methods (CustomerModel class methods)
    private final CustomerModel customerModel = new CustomerModel();

    public Button btnReport;
    public Button btnReset;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnSave;

    private final String textPattern = "^[A-Z a-z ]+$";
    private final String nicPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String phonePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
    public TableColumn<CustomerTM,Integer> tabCustomerId;
    public TableColumn<CustomerTM, String> tabName;
    public TableColumn<CustomerTM, String> tabEmail;
    public TableColumn<CustomerTM, String> tabPhone;
    public TableColumn<CustomerTM, String> tabAddress;
    public TableView tblCustomer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTable();
        try {
            resetPage();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
        }
    }

    public void initializeTable() {
        tabCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    private void loadTableData() throws SQLException {

        tblCustomer.setItems(FXCollections.observableArrayList(
                customerModel.getAll().stream()
                        .map(customerDTO -> new CustomerTM(
                                customerDTO.getId(),
                                customerDTO.getName(),
                                customerDTO.getEmail(),
                                customerDTO.getPhone(),
                                customerDTO.getAddress()
                        )).toList()
        ));
    }

    private void resetPage() {
        try {
            loadTableData();
            loadNextId();
            btnSave.setDisable(false);

            btnDelete.setDisable(true);
            btnUpdate.setDisable(true);

            txtName.setText("");
            txtAddress.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String customerId = lblCustomerId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();


        boolean isValidName = name.matches(textPattern);
        boolean isValidAddress = address.matches(textPattern);
        boolean isValidEmail = email.matches(emailPattern);
        boolean isValidPhone = phone.matches(phonePattern);


        txtName.setStyle(txtName.getStyle() + ";-fx-border-color: #7367F0;");
        txtAddress.setStyle(txtAddress.getStyle() + ";-fx-border-color: #7367F0;");
        txtEmail.setStyle(txtEmail.getStyle() + ";-fx-border-color: #7367F0;");
        txtPhone.setStyle(txtPhone.getStyle() + ";-fx-border-color: #7367F0;");

        if (!isValidName) txtName.setStyle(txtName.getStyle() + ";-fx-border-color: red;");
        if (!isValidAddress) txtAddress.setStyle(txtAddress.getStyle() + ";-fx-border-color: red;");
        if (!isValidEmail) txtEmail.setStyle(txtEmail.getStyle() + ";-fx-border-color: red;");
        if (!isValidPhone) txtPhone.setStyle(txtPhone.getStyle() + ";-fx-border-color: red;");


        if (isValidName && isValidAddress && isValidEmail && isValidPhone) {
            try {
                CustomerDTO customer = new CustomerDTO(
                        Integer.parseInt(customerId),
                        name,
                        email,
                        phone,
                        address
                );
                boolean isSaved = customerModel.add(customer);

                if (isSaved) {
                    resetPage();
                    new Alert(Alert.AlertType.INFORMATION, "Customer saved successfully.").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to save customer.").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Fail to save customer.").show();
            }
        }
    }

    public void btnGenarateReportOnAction(ActionEvent actionEvent) {
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        resetPage();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String customerId = lblCustomerId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();

        try {
            CustomerDTO customer = new CustomerDTO(
                    Integer.parseInt(customerId),
                    name,
                    email,
                    phone,
                    address
            );
            boolean isUpdate = customerModel.update(customer);

            if (isUpdate) {
                resetPage();
                new Alert(Alert.AlertType.INFORMATION, "Customer saved successfully.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to save customer.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to save customer.").show();
        }
    }

    private void loadNextId() {
        try {
            int nextId = customerModel.getNextId();
            lblCustomerId.setText(String.valueOf(nextId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void custabOnMouseClicked(MouseEvent mouseEvent) {
        CustomerTM selectedItem = (CustomerTM) tblCustomer.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            lblCustomerId.setText(String.valueOf(selectedItem.getId()));
            txtName.setText(selectedItem.getName());
            txtAddress.setText(selectedItem.getAddress());
            txtEmail.setText(selectedItem.getEmail());
            txtPhone.setText(selectedItem.getPhone());

            btnSave.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
        }

    }
}