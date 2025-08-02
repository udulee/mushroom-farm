package lk.ijse.mushroom.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.FarmHouseDTO;
import lk.ijse.mushroom.dto.tm.FarmHouseTM;
import lk.ijse.mushroom.model.FarmHouseModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FarmHouseController implements Initializable {

    private final FarmHouseModel farmHouseModel = new FarmHouseModel();


    private final String textPattern = "^[A-Z a-z ]+$";
    private final String SizePattern = "^(\\d+)||((\\d+\\.)(\\d){2})$";
    public TableView<FarmHouseTM> tblFarmHouse;
    public TableColumn<FarmHouseTM, Integer> tabFarmId;
    public TableColumn<FarmHouseTM, String> tabLocation;
    public TableColumn<FarmHouseTM, Double> tabSize;


    public TextField txtFarmId;
    public TextField txtLocation;
    public TextField txtSize;
    public Button btnFarmDelete;
    public Button btnFarmUpdate;
    public Button btnFarmAdd;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTable();
        try {
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
        }
        loadNextId();
        try {
            loadTableData();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public void initializeTable() {
        tabFarmId.setCellValueFactory(new PropertyValueFactory<>("farmId"));
        tabLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        tabSize.setCellValueFactory(new PropertyValueFactory<>("size"));
    }

    private void loadTableData() throws SQLException {

        tblFarmHouse.setItems(FXCollections.observableArrayList(
                FarmHouseModel.getAll().stream()
                        .map(farmdto -> new FarmHouseTM(
                                farmdto.getFarmId(),
                                farmdto.getLocation(),
                                farmdto.getSize()
                        )).toList()
        ));
    }


    public void btnAddButtonOnAction(ActionEvent actionEvent) {
        String FarmHouseId = txtFarmId.getText();
        String Location = txtLocation.getText();
        Double Size = Double.valueOf(txtSize.getText());

        try {
            FarmHouseDTO farmHouse = new FarmHouseDTO(
                    Integer.parseInt(FarmHouseId),
                    Location,
                    Size
            );
            boolean isAdd = FarmHouseModel.add(farmHouse);

            if (isAdd) {
                new Alert(Alert.AlertType.INFORMATION, "Farmhouse add successfully.").show();
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
            int nextId = farmHouseModel.getNextId();
            txtFarmId.setText(String.valueOf(nextId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
        String FarmHouseId = txtFarmId.getText();
        String Location = txtLocation.getText();
        Double size = Double.valueOf(txtSize.getText());

        try {
            FarmHouseDTO farmHouse = new FarmHouseDTO(
                    Integer.parseInt(FarmHouseId),
                    Location,
                    size
            );
            boolean isUpdate = FarmHouseModel.update(farmHouse);

            if (isUpdate) {
                new Alert(Alert.AlertType.INFORMATION, "Farmhouse update successfully.").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Fail to update farmHouse.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to save update.").show();
        }
    }



    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {

    }

    public void tabFarmHouseOnMouseClicked(MouseEvent mouseEvent) {
        FarmHouseTM selectedItem = tblFarmHouse.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            txtFarmId.setText(String.valueOf(selectedItem.getFarmId()));
            txtLocation.setText(selectedItem.getLocation());
            txtSize.setText(String.valueOf(selectedItem.getSize()));


            btnFarmAdd.setDisable(true);
            btnFarmUpdate.setDisable(false);
            btnFarmDelete.setDisable(false);
        }

    }

}


