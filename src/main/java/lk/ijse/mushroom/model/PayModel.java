package lk.ijse.mushroom.model;

import lk.ijse.mushroom.dto.PayDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayModel {
    public boolean Add(PayDTO payDTO) throws SQLException {
        boolean isAdded = CrudUtil.execute("INSERT INTO PAY Values(?,?,?,?,?)", payDTO.getPaymentId(),payDTO.getOrderId(),payDTO.getPaymentMethod(),payDTO.getPaymentDate(),payDTO.getAmount());
        return isAdded;
    }
    public static boolean Update(PayDTO payDTO) throws SQLException {
        boolean isUpdated = CrudUtil.execute("UPDATE pay SET OrderId=?,paymentMethod=?,paymentDate=?,amount=? WHERE PaymentId=?",payDTO.getOrderId(),payDTO.getPaymentMethod(),payDTO.getPaymentDate(),payDTO.getAmount(),payDTO.getPaymentId());
        return isUpdated;
    }
    public boolean Delete(PayDTO payDTO) throws SQLException {
        boolean IsDeleted = CrudUtil.execute("DELETE FROM PAY WHERE PaymentId=?",payDTO.getPaymentId());
        return IsDeleted;
    }
    public static ArrayList<PayDTO> GetAll() throws SQLException {
        ArrayList<PayDTO> payDTOs = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM PAY");

        while (rs.next()) {
            PayDTO payDTO = new PayDTO(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
            payDTOs.add(payDTO);
        }
        return payDTOs;
    }
    public static int getNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT MAX(PaymentId) FROM PAY");
        if (rs.next()) {
            int nextId = rs.getInt(1) + 1;
            System.out.println(nextId);
            return nextId;
        }
        return 0;
    }
}
