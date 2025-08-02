package lk.ijse.mushroom.model;

import lk.ijse.mushroom.dto.CustomerDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public boolean add(CustomerDTO customerDTO) throws SQLException {
        boolean isAdded = CrudUtil.execute("INSERT INTO customer Values(?,?,?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getEmail(),customerDTO.getPhone(),customerDTO.getAddress());
        return isAdded;
    }

    public boolean update(CustomerDTO customerDTO) throws SQLException {
        boolean isUpdated = CrudUtil.execute("UPDATE customer SET name=?,email=?,contact=?,Address= ? WHERE id = ?",customerDTO.getName(),customerDTO.getEmail(),customerDTO.getPhone(),customerDTO.getAddress(),customerDTO.getId());
        return  isUpdated;
    }


    public boolean delete(int id) throws SQLException {
        boolean isDeleted = CrudUtil.execute("DELETE FROM customer WHERE customerId = ?",id);
        return isDeleted;
    }

    public ArrayList<CustomerDTO> getAll() throws SQLException {
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM customer");

        while (rs.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    public int getNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT MAX(customer_id) FROM customer");
        if (rs.next()) {
            int nextId = rs.getInt(1) + 1;
            System.out.println(nextId);
            return nextId;
        }
        return 0;
    }
}
