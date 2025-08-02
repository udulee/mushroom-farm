package lk.ijse.mushroom.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.mushroom.dto.FeedbackDTO;
import lk.ijse.mushroom.dto.tm.FeedbackTM;
import lk.ijse.mushroom.model.FeedbackModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FeedbackController implements Initializable {

        public TableView<FeedbackTM> tblFeedback;
        public TableColumn<FeedbackTM,Integer> tabFeedbackId;
        public TableColumn<FeedbackTM,Integer> tabCustomerId;
        public TableColumn<FeedbackTM,String> tabRating;
        public TableColumn<FeedbackTM,String> tabComment;

        private final FeedbackModel feedbackModel = new FeedbackModel();
        public Button btnAdd;
        public Button btnDelete;
        public Button btnUpdate;

        private final String textPattern = "^[A-Z a-z ]+$";
        private final String RatingPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        public TextField txtFeedbackId;
        public TextField txtCustomerId;
        public TextField txtRating;
        public TextField txtComment;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            // table column and tm class properties link
            initializeTable();
            try {
                //     resetPage();
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Something went wrong.").show();
            }
            loadNextId();
            try {
                loadTableData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public void initializeTable() {
            tabFeedbackId.setCellValueFactory(new PropertyValueFactory<>("feedbackId"));
            tabCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            tabRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
            tabComment.setCellValueFactory(new PropertyValueFactory<>("comment"));
        }

        private void loadTableData() throws SQLException {

            tblFeedback.setItems(FXCollections.observableArrayList(
                    FeedbackModel.getAll().stream()
                            .map(feedbackDTO -> new FeedbackTM(
                                    feedbackDTO.getFeedbackId(),
                                    feedbackDTO.getCustomerId(),
                                    feedbackDTO.getRating(),
                                    feedbackDTO.getComment()
                            )).toList()
            ));
        }



        public void btnAddButtonOnAction(ActionEvent actionEvent) {
        }

        public void btnUpdateButtonOnAction(ActionEvent actionEvent) {
            String feedbackId = txtFeedbackId.getText();
            String customerId = txtCustomerId.getText();
            String rating = txtRating.getText();
            String comment = txtComment.getText();

            try {
                FeedbackDTO feedback = new FeedbackDTO(
                        Integer.parseInt(feedbackId),
                        Integer.parseInt(customerId),
                        rating,
                        comment

                );
                boolean isUpdate = feedbackModel.update(feedback);

                if (isUpdate) {
                    // resetPage();
                    new Alert(Alert.AlertType.INFORMATION, "Feedback saved successfully.").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Fail to save feedback.").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Fail to save feedback.").show();
            }
        }

        private void loadNextId() {
            try {
                int nextId = feedbackModel.getNextId();
                txtFeedbackId.setText(String.valueOf(nextId));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    public void btnDeleteButtonOnAction(ActionEvent actionEvent) {

    }

    public void tblFeedbackOnMouseClicked(MouseEvent mouseEvent) {
        FeedbackTM selectedItem = (FeedbackTM) tblFeedback.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            txtFeedbackId.setText(String.valueOf(selectedItem.getFeedbackId()));
            txtCustomerId.setText(String.valueOf(selectedItem.getCustomerId()));
            txtRating.setText(selectedItem.getRating());
            txtComment.setText(selectedItem.getComment());

            btnAdd.setDisable(true);
            btnDelete.setDisable(false);
            btnUpdate.setDisable(false);
        }

    }

}
