//package lk.ijse.mushroom.model;
//
//import lk.ijse.mushroom.dto.DeliverPageDTO;
//import lk.ijse.mushroom.util.CrudUtil;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class DeliverPageModel {
//    public boolean Add (DeliverPageDTO deliverPageDTO)throws SQLException {
//        boolean isAdded = CrudUtil.execute("INSERT INTO DeliverPage Values(?,?,?,?)",deliverPageDTO.getDeliverId(),deliverPageDTO.getOrderId(),deliverPageDTO.getCustomerId(),deliverPageDTO.getOrderAmount());
//        return isAdded;
//    }
//    public boolean Update (DeliverPageDTO deliverPageDTO)throws SQLException {
//        boolean isUpdated = CrudUtil.execute("UPDATE Deliver SET OrderId=?,CustomerId=?,OrderAmount=? WHERE DeliverId=?",deliverPageDTO.getCustomerId(),deliverPageDTO.getOrderId(),deliverPageDTO.getDeliverId(),deliverPageDTO.getDeliverId());
//        return isUpdated;
//    }
//    public boolean Delete (DeliverPageDTO deliverPageDTO)throws SQLException {
//        boolean isDeleted = CrudUtil.execute("DELETE FROM Deliver WHERE DeliverId=?",deliverPageDTO.getDeliverId());
//        return isDeleted;
//    }
//    public ArrayList<DeliverPageDTO> GetAllDeliverPage()throws SQLException {
//        ArrayList<DeliverPageDTO> deliverPageDTOs = new ArrayList<>();
//        ResultSet rs = CrudUtil.execute("SELECT * FROM Deliver");
//
//        while (rs.next()) {
//            DeliverPageDTO deliverPageDTO = new DeliverPageDTO(
//                    rs.getInt(1),
//                    rs.getInt(2),
//                    rs.getInt(3),
//                    rs.getString(4)
//            );
//            deliverPageDTOs.add(deliverPageDTO);
//        }
//        return deliverPageDTOs;
//    }
//    public int getNextId()throws SQLException {
//        ResultSet rs = CrudUtil.execute("SELECT MAX(DeliverId) FROM Deliver");
//        if(rs.next()){
//            int nextId = rs.getInt(1) + 1;
//            System.out.println(nextId);
//            return nextId;
//        }
//        return 0;
//    }
//
//}

package lk.ijse.mushroom.model;

import lk.ijse.mushroom.dto.DeliverPageDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliverPageModel {

    // Add new delivery
    public boolean add(DeliverPageDTO dto) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO Deliver (DeliverId, OrderId, CustomerId, OrderAmount) VALUES (?, ?, ?, ?)",
                dto.getDeliverId(),
                dto.getOrderId(),
                dto.getCustomerId(),
                dto.getOrderAmount()
        );
    }

    // Update existing delivery
    public boolean update(DeliverPageDTO dto) throws SQLException {
        return CrudUtil.execute(
                "UPDATE Deliver SET OrderId = ?, CustomerId = ?, OrderAmount = ? WHERE DeliverId = ?",
                dto.getOrderId(),
                dto.getCustomerId(),
                dto.getOrderAmount(),
                dto.getDeliverId()
        );
    }

    // Delete delivery by ID
    public boolean delete(int deliverId) throws SQLException {
        return CrudUtil.execute("DELETE FROM Deliver WHERE DeliverId = ?", deliverId);
    }

    // Get all delivery records
    public ArrayList<DeliverPageDTO> getAll() throws SQLException {
        ArrayList<DeliverPageDTO> list = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Deliver");

        while (rs.next()) {
            DeliverPageDTO dto = new DeliverPageDTO(
                    rs.getInt("DeliverId"),
                    rs.getInt("OrderId"),
                    rs.getInt("CustomerId"),
                    rs.getString("OrderAmount")
            );
            list.add(dto);
        }
        return list;
    }

    // Get next auto-increment DeliverId
    public int getNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT MAX(DeliverId) FROM Deliver");
        if (rs.next()) {
            return rs.getInt(1) + 1;
        }
        return 1;
    }
}
