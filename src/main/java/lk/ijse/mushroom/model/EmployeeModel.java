package lk.ijse.mushroom.model;

import lk.ijse.mushroom.dto.CustomerDTO;
import lk.ijse.mushroom.dto.EmployeeDTO;
import lk.ijse.mushroom.util.CrudUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public boolean add(EmployeeDTO employeeDTO) throws SQLException {
        boolean isAdded = CrudUtil.execute("INSERT INTO employee Values(?,?,?,?,?,?)", employeeDTO.getEmployee_id(),employeeDTO.getFirst_name(),employeeDTO.getLast_name(),employeeDTO.getEmail(),employeeDTO.getContact(),employeeDTO.getSalary());
        return isAdded;
    }

    public boolean update(EmployeeDTO employeeDTO) throws SQLException {
        boolean isUpdated = CrudUtil.execute("UPDATE Employee SET Frist_name=? Last_name,email=?,contact=?,salary= ? WHERE employeeId = ?",employeeDTO.getFirst_name(),employeeDTO.getLast_name(),employeeDTO.getEmail(),employeeDTO.getContact(),employeeDTO.getSalary(),employeeDTO.getEmployee_id());
        return  isUpdated;
    }
    public boolean delete(EmployeeDTO employeeDTO) throws SQLException {
        boolean isdelete = CrudUtil.execute("DELETE FROM employee WHERE employeeId = ?",employeeDTO.getEmployee_id());
        return isdelete;
    }
    public static ArrayList<EmployeeDTO> getAll() throws SQLException {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM employee");

        while (rs.next()) {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(6),
                    rs.getString(5),
                    rs.getString(4)
            );
            employees.add(employeeDTO);
        }
        return employees;
    }
    public int getnextId() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT MAX(id) FROM employee");
        if (rs.next()) {
            return rs.getInt(1)+1;
        }
        return 0;
    }


    public int getNextId() {
        return 0;
    }
}
