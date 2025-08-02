package lk.ijse.mushroom.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.EmployeeDTO;
import lk.ijse.mushroom.dto.tm.EmployeeTM;
import lk.ijse.mushroom.model.EmployeeModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeePageController implements Initializable {


    public TableView<EmployeeTM> tblEmployee;
    public TableColumn<EmployeeTM,Integer> tabEmployeeId;
    public TableColumn<EmployeeTM,String> tabContact;
    public TableColumn<EmployeeTM,Double> tabSalary;
    public TableColumn<EmployeeTM,String> tabEmail;
    public TableColumn<EmployeeTM,String> tabFristName;
    public TableColumn<EmployeeTM,String> tabLastName;

    private final EmployeeModel employeeModel = new EmployeeModel();

  

    private final String textPattern = "^[A-Z a-z ]+$";
    private final String salaryPattern = "^[0-9]{9}[vVxX]||[0-9]{12}$";
    private final String emailPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private final String ContactPattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
    
//    public TableColumn tabFirstName;
//    public TableColumn tabLastname;
    public TextField txtEmployeeId;
    public TextField txtFristName;
    public TextField txtLastName;
    public TextField txtContact;
    public TextField txtSalary;
    public TextField txtEmail;

    public Button btnEmpDelete;
    public Button btnEmpUpdate;
    public Button btnEmpAdd;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        initializeTable();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
        }
        loadNextId();
        try {
            resetPage();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
            e.printStackTrace();
        }
    }

    public void initializeTable() {
        tabEmployeeId.setCellValueFactory(new PropertyValueFactory<>("Employee_id"));
        tabFristName.setCellValueFactory(new PropertyValueFactory<>("First_name"));
        tabLastName.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        tabSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tabContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    }
        public void resetPage() throws Exception {
        try {
            loadTableData();
            loadNextId();
//            btnEmpAdd.setDisable(false);
//            btnEmpUpdate.setDisable(true);
//            btnEmpDelete.setDisable(true);

            txtFristName.setText("");
            txtLastName.setText("");
            txtContact.setText("");
            txtSalary.setText("");
            txtEmail.setText("");
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
        }

    }
    public void loadTableData() throws SQLException {

        tblEmployee.setItems(FXCollections.observableArrayList(
                EmployeeModel.getAll().stream()
                        .map(employeeDTO -> new EmployeeTM(
                                employeeDTO.getEmployee_id(),
                                employeeDTO.getFirst_name(),
                                employeeDTO.getLast_name(),
                                employeeDTO.getSalary(),
                                employeeDTO.getContact(),
                                employeeDTO.getEmail()
                        )).toList()
        ));
    }
//    public void btnSaveOnAction(ActionEvent actionEvent) {
//     String EmployeeId = txtEmployeeId.getText();
//     String FristName = txtFristName.getText();
//     String lastName = txtLastName.getText();
//     String email = txtEmail.getText();
//     String Contact = txtContact.getText();
//     String salary = txtSalary.getText();
//
//     boolean isValidFristName = FristName.matches(textPattern);
//     boolean isValidLastName = lastName.matches(textPattern);
//     boolean isValidEmail = email.matches(emailPattern);
//    boolean isValidContact = Contact.matches(textPattern);
//    boolean isValidSalary = salary.matches(salaryPattern);
//
//    txtFristName.setStyle(txtFristName.getStyle() + ";-fx-border-color: #7367F0;");
//    txtLastName.setStyle(txtLastName.getStyle() + ";-fx-border-color: #7367F0;");
//    txtEmail.setStyle(txtEmail.getStyle() + ";-fx-border-color: #7367F0;");
//    txtContact.setStyle(txtContact.getStyle() + ";-fx-border-color: #7367F0;");
//     txtSalary.setStyle(txtSalary.getStyle() + ";-fx-border-color: #7367F0;");
//
//    if (!isValidFristName) txtFristName.setStyle(txtFristName.getStyle() + ";-fx-border-color: red;");
//    if (!isValidLastName) txtLastName.setStyle(txtLastName.getStyle() + ";-fx-border-color: red;");
//    if (!isValidEmail) txtEmail.setStyle(txtEmail.getStyle() + ";-fx-border-color: red;");
//    if (!isValidContact) txtContact.setStyle(txtContact.getStyle() + ";-fx-border-color: red;");
//    if (!isValidSalary) txtSalary.setStyle(txtSalary.getStyle() + ";-fx-border-color: red;");
//
//    if (isValidFristName && isValidLastName && isValidEmail && isValidContact && isValidSalary) {
//    try {
//     EmployeeDTO employeeDTO = new EmployeeDTO(
//    Integer.parseInt(EmployeeId),
//      FristName,
//     lastName,
//    Double.parseDouble(salary),
//     Contact,
//     email
//    );
//    boolean isSaved = employeeModel.add(employeeDTO);
//
//    if (isSaved) {
//        resetPage();
//      new Alert(Alert.AlertType.INFORMATION, "Employee saved successfully.").show();
//     } else {
//        new Alert(Alert.AlertType.ERROR, "Fail to save employee.").show();
//      }
//      } catch (Exception e) {
//     e.printStackTrace();
//     new Alert(Alert.AlertType.ERROR, "Fail to save employee.").show();
//     }
//     }
//       }


    public void btnAddButtonOnAction(ActionEvent actionEvent) {
        String EmployeeId = txtEmployeeId.getText();
        String FristName = txtFristName.getText();
        String lastName = txtLastName.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        String salary = txtSalary.getText();

        try {
            EmployeeDTO employee = new EmployeeDTO(
                    Integer.parseInt(EmployeeId),
                    FristName,
                    lastName,
                   Double.parseDouble(email),
                    contact,
                    salary
            );
            boolean isAdd = employeeModel.add(employee);

            if (isAdd) {
                resetPage();
                new Alert(Alert.AlertType.INFORMATION, "Employee add successfully.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to add .").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to save Add.").show();
        }
    }
    private void loadNextId() {
        try {
            int nextId = employeeModel.getNextId();
            txtEmployeeId.setText(String.valueOf(nextId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


public void UpdateButtonOnAction(ActionEvent actionEvent) {
    String EmployeeId = txtEmployeeId.getText();
    String FristName = txtFristName.getText();
    String lastName = txtLastName.getText();
    String email = txtEmail.getText();
    String contact = txtContact.getText();
    Double salary = Double.valueOf(txtSalary.getText());

    try {
        EmployeeDTO employee = new EmployeeDTO(
                Integer.parseInt(EmployeeId),
                FristName,
                lastName,
                salary,
                contact,
                String.valueOf(salary)
        );
        boolean isUpdate = employeeModel.update(employee);

        if (isUpdate) {
            new Alert(Alert.AlertType.INFORMATION, "Employee update successfully.").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to update update.").show();
        }
    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Fail to save update.").show();
    }
}



public void btnDeleteButtonOnAction(ActionEvent actionEvent) {

}

    public void tabEmployeeMouseOnClick(MouseEvent mouseEvent) {
        EmployeeTM selectedItem = (EmployeeTM) tblEmployee.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            txtEmployeeId.setText(String.valueOf(selectedItem.getEmployee_id()));
            txtFristName.setText(selectedItem.getFirst_name());
            txtLastName.setText(selectedItem.getLast_name());
            txtEmail.setText(selectedItem.getEmail());
            txtContact.setText(selectedItem.getContact());
            txtSalary.setText(String.valueOf(selectedItem.getSalary()));

            btnEmpAdd.setDisable(true);
            btnEmpDelete.setDisable(false);
            btnEmpUpdate.setDisable(false);
        }
    }
}

        
