package lk.ijse.mushroom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.ProductDTO;
import lk.ijse.mushroom.model.ProductModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    public TableColumn tabProductId;
    public TableColumn tabProductName;
    public TableColumn tabQuality;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView tableView;

    public ProductModel model=new ProductModel();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lordTable();
    }
    public void lordTable() {
        tabProductId.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        tabProductName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        tabQuality.setCellValueFactory(new PropertyValueFactory<>("quality"));

        try {
            tableView.setItems(model.getAll());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void btnButtonOnAction(ActionEvent actionEvent) {
    }

    public void btnAddButtonOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {
        
    }

    public void tabProductOnMouseClicked(MouseEvent mouseEvent) {

    }
}
