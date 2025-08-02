package lk.ijse.mushroom.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.tm.MushroomBatchTM;

public class MushroomBatchController {
    public TableView<MushroomBatchTM> tblBatch;
    public TableColumn<MushroomBatchTM,Integer> tabBatchId;
    public TableColumn<MushroomBatchTM,Integer> tabFarmId;
    public TableColumn<MushroomBatchTM,Integer> tabCustomerId;
    public TableColumn<MushroomBatchTM,String> tabMushroomType;
    public TableColumn<MushroomBatchTM,String> tabQuality;
    public TableColumn<MushroomBatchTM,String> tabQualityStatus;

    public void btnAddButtonOnAction(ActionEvent actionEvent) {
    }

    public void BtnUpdateButtonOnAction(ActionEvent actionEvent) {
    }

    public void BtnDeleteButtonOnAction(ActionEvent actionEvent) {
        
    }

    public void tabMushroomBatchOnMouseClicked(MouseEvent mouseEvent) {
    }
}
