package lk.ijse.mushroom.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.mushroom.dto.OrderDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel {
    public boolean add(OrderDTO orderDTO) throws SQLException{
        boolean isAdded = CrudUtil.execute("INSERT INTO Order Values (?,?,?,?,?)", orderDTO.getOrderId(),orderDTO.getCustomerId(),orderDTO.getPaymentStatus(),orderDTO.getOrderDate(),orderDTO.getTotalAmount());
        return isAdded;
    }
    public boolean update(OrderDTO orderDTO) throws SQLException{
        boolean isUpdate =CrudUtil.execute("UPDATE Order SET CustomerId=?,PaymentStatus=?,OrderDate=?,TotalAmount=? WHERE OrderId=?");
        return isUpdate;
    }
    public boolean delete(OrderDTO orderDTO) throws SQLException{
        boolean isDelete =CrudUtil.execute("DELETE FROM Order WHERE OrderId=?");
        return isDelete;
    }
    public ObservableList<OrderDTO> getOrders() throws SQLException{
        ArrayList<OrderDTO> orders = new ArrayList<>();
        ObservableList<OrderDTO> ordersObservableList = FXCollections.observableArrayList();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Orders");

        while(rs.next()){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(rs.getInt(1));
            orderDTO.setCustomerId(rs.getInt(2));
            orderDTO.setPaymentStatus(rs.getString(3));
            orderDTO.setOrderDate(rs.getString(4));
            String totalAmount = Double.toString(rs.getDouble(5));
            orderDTO.setTotalAmount(totalAmount);
            ordersObservableList.add(orderDTO);
        }
        return ordersObservableList;
    }
    public int getNextId() throws SQLException{
        ResultSet rs = CrudUtil.execute("SELECT MAX(OrderId) FROM Order");
        if(rs.next()){
            int nextId = rs.getInt(1) + 1;
            System.out.println(nextId);
            return nextId;
        }
        return 0;
    }


}
