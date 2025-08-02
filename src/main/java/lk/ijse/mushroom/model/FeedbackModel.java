package lk.ijse.mushroom.model;

import lk.ijse.mushroom.dto.FeedbackDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FeedbackModel {


    public boolean add(FeedbackDTO feedbackDTO) throws SQLException {
        Boolean isAdded = CrudUtil.execute("INSERT INTO Feedback Values(?,?,?,?)",feedbackDTO.getFeedbackId(),feedbackDTO.getCustomerId(),feedbackDTO.getRating(),feedbackDTO.getComment());
        return isAdded;
    }
    public boolean update(FeedbackDTO feedbackDTO) throws SQLException {
        Boolean isUpdated = CrudUtil.execute("UPDATE Feedback SET customer_id =?,rating =?,comment =?,WHERE Feedback_id =?",feedbackDTO.getCustomerId(),feedbackDTO.getRating(),feedbackDTO.getComment(),feedbackDTO.getFeedbackId());
        return isUpdated;
    }
    public boolean delete(FeedbackDTO feedbackDTO) throws SQLException {
        Boolean isDelete = CrudUtil.execute("DELETE FROM Feedback WHERE Feedback_id =?",feedbackDTO.getFeedbackId());
        return isDelete;
    }
    public static ArrayList<FeedbackDTO> getAll() throws SQLException {
        ArrayList<FeedbackDTO> feedbackDTOs = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Feedback");

        while (rs.next()) {
            FeedbackDTO feedbackDTO = new FeedbackDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4)
            );
            feedbackDTOs.add(feedbackDTO);
        }
        return feedbackDTOs;
    }


    public int getNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT Feedback_id FROM Feedback");
        rs.next();
        int nextId = rs.getInt(1)+1;
        System.out.println(nextId);
        return nextId;
    }
}
